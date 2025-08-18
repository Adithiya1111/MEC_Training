document.addEventListener('DOMContentLoaded', function() {
    const submitBtn = document.getElementById('submit');
    const numberInput = document.getElementById('number');
    const shapeContainer = document.getElementById('shape-container');
   
    
    let shapeCounter = 0;
    
    submitBtn.addEventListener('click', generateShapes);
    
    function generateShapes() {
        
        const selectedShape = document.querySelector('input[name="shape"]:checked').value;
        const count = parseInt(numberInput.value) || 1;
        
      
        const shapeCount = Math.min(Math.max(count, 1), 10);
        
        for (let i = 0; i < shapeCount; i++) {
            shapeCounter++;
            const shape = document.createElement('div');
            shape.className = `generated-shape ${selectedShape}`;
     
            shape.style.width = '100px';
            shape.style.height = '100px';
            
            if (selectedShape === 'rectangle') {
                shape.style.width = '150px';
                shape.style.height = '100px';
            }
            
        
            shape.textContent = shapeCounter - 1; 
            
            
            shape.addEventListener('click', function() {
                this.remove();
            });
            
            shapeContainer.appendChild(shape);
        }
    }
   
});