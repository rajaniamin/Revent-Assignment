const imageContainer = document.querySelector(".stuimg");
const images = [
    "https://th.bing.com/th/id/OIP.qVqfw9ozWSxyfWWlVcK3twHaE8?w=270&h=180&c=7&r=0&o=5&dpr=1.4&pid=1.7",
    "https://th.bing.com/th/id/OIP.UUyLsiuqcli4OevzNETlHAHaEK?w=320&h=180&c=7&r=0&o=5&dpr=1.4&pid=1.7",
    "https://th.bing.com/th/id/OIP.qVqfw9ozWSxyfWWlVcK3twHaE8?w=270&h=180&c=7&r=0&o=5&dpr=1.4&pid=1.7",
    "https://th.bing.com/th/id/OIP.UUyLsiuqcli4OevzNETlHAHaEK?w=320&h=180&c=7&r=0&o=5&dpr=1.4&pid=1.7",
    
];
let currentImageIndex = 0;

function changeImage() {
    imageContainer.style.opacity = 0;
    const imageElement = imageContainer.querySelector("img");
    imageElement.src = images[currentImageIndex];
    currentImageIndex = (currentImageIndex + 1) % images.length;
    imageContainer.style.opacity = 1;
}

setInterval(changeImage, 3000); // Change image every 2 seconds