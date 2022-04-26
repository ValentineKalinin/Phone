package enums;

import enums.Store;

import static phone.Main.LOGGER;

public enum ShopWorkTime {
    FULL_TIME_WORK {
        @Override
        public void info() {
            LOGGER.info("You can visit anytime store at " + Store.MAIN_OFFICE.getAddress());
        }
    },
    EVENING_WORKING {
        @Override
        public void info() {
            LOGGER.info("You can visit in the evening store at " + Store.MAIN_OFFICE.getAddress() + " or at " + Store.STORE_CENTRE.getAddress());
        }
    },
    MORNING_WORKING {
        @Override
        public void info() {
            LOGGER.info("You can visit in the morning store at " + Store.MAIN_OFFICE.getAddress() + " or at " + Store.STORE_WEST.getAddress());
        }
    };

    public abstract void info();
}
