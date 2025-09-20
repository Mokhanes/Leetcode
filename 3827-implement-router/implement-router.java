import java.util.*;

public class Router {
    private int memoryLimit;
    // To detect duplicates
    private Set<Packet> uniquePackets;
    // To maintain FIFO order
    private Queue<Packet> packetQueue;
    // For each destination, list of timestamps (sorted in non-decreasing order)
    private Map<Integer, List<Integer>> destTimestamps;
    // For each destination, how many timestamps have been removed / forwarded already,
    // so we don't count those in getCount
    private Map<Integer, Integer> processedCount;

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.uniquePackets = new HashSet<>();
        this.packetQueue = new LinkedList<>();
        this.destTimestamps = new HashMap<>();
        this.processedCount = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet p = new Packet(source, destination, timestamp);
        if (uniquePackets.contains(p)) {
            return false;
        }
        if (packetQueue.size() == memoryLimit) {
            forwardPacket();  // remove oldest
        }
        // Add new packet
        packetQueue.offer(p);
        uniquePackets.add(p);
        destTimestamps
            .computeIfAbsent(destination, k -> new ArrayList<>())
            .add(timestamp);
        // ensure processedCount has an entry
        processedCount.putIfAbsent(destination, 0);
        return true;
    }

    public List<Integer> forwardPacket() {
        if (packetQueue.isEmpty()) {
            return Collections.emptyList();
        }
        Packet oldest = packetQueue.poll();
        uniquePackets.remove(oldest);
        int dest = oldest.destination;
        int ts = oldest.timestamp;
        // logically remove this timestamp from count for that destination
        // We will not remove from the list (expensive), but maintain a processedCount to skip
        processedCount.put(dest, processedCount.getOrDefault(dest, 0) + 1);
        return Arrays.asList(oldest.source, oldest.destination, oldest.timestamp);
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> timestamps = destTimestamps.get(destination);
        if (timestamps == null) {
            return 0;
        }
        int startIdx = processedCount.getOrDefault(destination, 0);
        // binary search for left boundary ≥ startTime
        int left = firstGreaterEqual(timestamps, startIdx, startTime);
        // binary search for right boundary > endTime
        int right = firstGreater(timestamps, startIdx, endTime);
        return right - left;
    }

    // Helper binary search: first index ≥ target, in timestamps[startIdx .. end)
    private int firstGreaterEqual(List<Integer> list, int startIdx, int target) {
        int lo = startIdx, hi = list.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    // Helper: first index > target
    private int firstGreater(List<Integer> list, int startIdx, int target) {
        int lo = startIdx, hi = list.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    // Packet class with equals + hashCode for duplicates
    private static class Packet {
        int source;
        int destination;
        int timestamp;

        public Packet(int source, int destination, int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Packet other = (Packet) o;
            return source == other.source
                && destination == other.destination
                && timestamp == other.timestamp;
        }

        @Override
        public int hashCode() {
            return Objects.hash(source, destination, timestamp);
        }
    }
}
