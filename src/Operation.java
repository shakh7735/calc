public enum Operation {

        ADDITION {
            public int action(int x, int y) {
                return x + y;
            }
        },
        SUBSTRACTION {
            public int action(int x, int y) {
                return x - y;
            }
        },
        MULTIPLICATION {
            public int action(int x, int y) {
                return x * y;
            }
        },
        DIVISION {
            public int action(int x, int y) {
                return x / y;
            }
        };

        public abstract int action(int x, int y);
    }

