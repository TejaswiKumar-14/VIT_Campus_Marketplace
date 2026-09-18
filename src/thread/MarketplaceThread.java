package thread;

public class MarketplaceThread extends Thread {

    @Override
    public void run() {

        for (int i = 1; i <= 5; i++) {

            System.out.println(
                    "Checking marketplace activity... " + i
            );

            try {

                Thread.sleep(1000);

            } catch (InterruptedException e) {

                System.out.println(
                        "Marketplace thread interrupted."
                );
            }
        }

        System.out.println(
                "Marketplace activity check completed."
        );
    }
}