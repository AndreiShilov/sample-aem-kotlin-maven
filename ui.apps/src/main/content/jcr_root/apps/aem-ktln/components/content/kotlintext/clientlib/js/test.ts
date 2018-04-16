class TestComponent {

    static register(): void {
        console.log("TestConponent from ts")
    }


    static toLowerCase(str: String): String {
        return str.toLowerCase();
    }
}

export default TestComponent