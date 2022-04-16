package main.java.enums;

public enum Course {
    FULL_TIME_WORK {
        @Override
        public void info() {
            System.out.println("Store at " + Store.MAIN_OFFICE.getAddress() + " open on " +
                    Days.WEDNESDAY + ", " + Days.THURSDAY + " and " + Days.FRIDAY);
        }
    },
    EVENING_WORKING {
        @Override
        public void info() {
            System.out.println("Store at " + Store.STORE_1.getAddress() + " open on " +
                    Days.MONDAY + " and " + Days.TUESDAY);
        }
    },
    MORNING_WORKING {
        @Override
        public void info() {
            System.out.println("Store at " + Store.STORE_2.getAddress() + " open on " +
                    Days.SATURDAY);
        }
    };
    public abstract void info();
}
