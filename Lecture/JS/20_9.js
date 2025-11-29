let money = 500;
console.log("Today I go out and I have " + money + " dollars");

function delay(s) {
    return new Promise(resolve => {
        setTimeout(resolve, s * 1000);
    });
}

delay(1)
    .then(() => {
        money -= 100;
        console.log("8h30 I go to cinema, now I have " + money + " dollars");
        return delay(1.5);
    })
    .then(() => {
        money -= 50;
        console.log("10h I go to restaurant, now I have " + money + " dollars");
        return delay(2);
    })
    .then(() => {
        money -= 40;
        console.log("12h I drink coffee, now I have " + money + " dollars");
        return delay(1);
    })
    .then(() => {
        console.log("13h I go back home, now I have " + money + " dollars");
    });
