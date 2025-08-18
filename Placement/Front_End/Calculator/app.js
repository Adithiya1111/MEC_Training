document.addEventListener('DOMContentLoaded', function() {
    const display = document.querySelector('.display');
    const buttons = document.querySelectorAll('.n1');
    
    let currentInput = '0';
    let previousInput = '';
    let operation = null;
    let shouldResetScreen = false;

    function updateDisplay() {
        display.textContent = currentInput;
    }

    function inputNumber(number) {
        if (currentInput === '0' || shouldResetScreen) {
            currentInput = number;
            shouldResetScreen = false;
        } else {
            currentInput += number;
        }
    }

    function inputDecimal() {
        if (shouldResetScreen) {
            currentInput = '0.';
            shouldResetScreen = false;
            return;
        }
        if (!currentInput.includes('.')) {
            currentInput += '.';
        }
    }

    function handleOperation(op) {
        // If we already have a previous input and operation, calculate first
        if (previousInput && operation && !shouldResetScreen) {
            calculate();
        }
        
        previousInput = currentInput;
        operation = op;
        shouldResetScreen = true;
    }

    function calculate() {
        let result;
        const prev = parseFloat(previousInput);
        const current = parseFloat(currentInput);
        
        if (isNaN(prev) || isNaN(current)) return;
        
        switch (operation) {
            case '+':
                result = prev + current;
                break;
            case '-':
                result = prev - current;
                break;
            case '*':
                result = prev * current;
                break;
            case '/':
                result = prev / current;
                break;
            case '%':
                result = prev % current;
                break;
            default:
                return;
        }
        
        currentInput = result.toString();
        operation = null;
        shouldResetScreen = true;
    }

    function clearAll() {
        currentInput = '0';
        previousInput = '';
        operation = null;
    }

    function deleteLastChar() {
        if (currentInput.length === 1 || (currentInput.length === 2 && currentInput.startsWith('-'))) {
            currentInput = '0';
        } else {
            currentInput = currentInput.slice(0, -1);
        }
    }

    // Add event listeners to all buttons
    buttons.forEach(button => {
        button.addEventListener('click', () => {
            const value = button.textContent;

            if (!isNaN(value) || value === '00') {
                if (value === '00') {
                    inputNumber('00');
                } else {
                    inputNumber(value);
                }
                updateDisplay();
            } else if (value === '.') {
                inputDecimal();
                updateDisplay();
            } else if (value === 'AC') {
                clearAll();
                updateDisplay();
            } else if (value === '=') {
                if (operation && previousInput) {
                    calculate();
                    updateDisplay();
                }
            } else if (value === 'X') {
                deleteLastChar();
                updateDisplay();
            } else {
                handleOperation(value);
                updateDisplay();
            }
        });
    });

    // Initialize display
    updateDisplay();
});