package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TransferAggregator {

    public List<TransferPerClient> readTransfers(Path path) {
        List<String> lines = readLines(path);
        return summarize(lines);
    }

    private List<TransferPerClient> summarize(List<String> lines) {
        Map<String, TransferPerClient> transfers = new TreeMap<>();
        for (String line: lines) {
            String[] parts = line.split(",");
            String sourceClientId = parts[0];
            String targetClientId = parts[1];
            int amount = Integer.parseInt(parts[2]);

//            TransferPerClient source = findOrInsert(transfers, sourceClientId);
            TransferPerClient source = transfers.computeIfAbsent(sourceClientId,
                    k -> new TransferPerClient(sourceClientId));
            source.decrease(amount);

//            TransferPerClient target = findOrInsert(transfers, targetClientId);
            TransferPerClient target = transfers.computeIfAbsent(targetClientId,
                    k -> new TransferPerClient(targetClientId));
            target.increase(amount);
        }
        return new ArrayList<>(transfers.values());
    }

//    private TransferPerClient findOrInsert(Map<String, TransferPerClient> transfers, String clientId) {
//        TransferPerClient transfer = transfers.get(clientId);
//        if (transfer == null) {
//            transfer = new TransferPerClient(clientId);
//            transfers.put(clientId, transfer);
//        }
//        return transfer;
//    }

    private List<String> readLines(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public static void main(String[] args) {
        List<TransferPerClient> transfers = new TransferAggregator()
                .readTransfers(Paths.get("src\\main\\resources\\transfers.csv"));

        for (TransferPerClient transfer: transfers) {
            System.out.printf("%s %,12d %5d\n",
                    transfer.getClientId(), transfer.getSum(), transfer.getNumberOfTransactions());
        }
    }

//    public List<TransferPerClient> tranfers(Path path) {
//        List<String> lines = readlines(path);
//        return null;
//    }
//
//    private List<String> readlines(Path path) {
//        try {
//            return Files.readAllLines(path);
//        } catch (IOException ioe) {
//            throw new IllegalStateException("Can not read file", ioe);
//        }
//    }
//
//
//    private List<TransferPerClient> summraise(List<String> lines) {
//        Map<String, TransferPerClient> result = new TreeMap<>();
//        for (String line : lines) {
//            String[] parts = line.split(",");
//            String sourceClientId = parts[0];
//            String targetClientId = parts[1];
//            int amount = Integer.parseInt(parts[2]);
//
//TransferPerClient source = tranfers().comput
//
////            TransferPerClient source = transfers.get(sourceClientId);
////            if (source == null) {
////                source = new TransferPerClient(sourceClientId);
////                tranfers().put(sourceClientId, source);
////            }
////            source.decrease(amount);
////        }
////        TransferPerClient target = transfers.get(sourceClientId);
////        if (target == null) {
////            target = new TransferPerClient(sourceClientId);
////            tranfers().put(sourceClientId, target);
////        }
////        target.decrease(amount);
//    }
//}
//
//
//
//   private TransferPerClient findOrInsert(Map<String, TransferPerClient> transfer, String clientId) {
//        TransferPerClient transfer = tranfers.get(clientId);
//    }
//
//    private void parseLine(Map<String, TransferPerClient> result, String line) {
//        String[] parts = line.split(",");
//        int amount = Integer.parseInt(parts[2]);
//        if (!result.containsKey(parts[0])) {
//            result.put(parts[0], new TransferPerClient(parts[0]));
//        }
//        if (!result.containsKey(parts[1])) {
//            result.put(parts[1], new TransferPerClient(parts[1]));
//        }
//        result.get(parts[0]).decrease(amount);
//        result.get(parts[1]).increase(amount);
//    }
//
//    public List<TransferPerClient> writeTransferToFile(Path path, List<String> tranfers) {
//        try {
//            Files.write(Paths.get("transfers.txt"), readTranfers()) );
//        } catch (
//                IOException ioe) {
//            throw new IllegalStateException("Can not write file", ioe);
//        }
//    }
}
