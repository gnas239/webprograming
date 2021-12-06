
const navbarUser = document.querySelector('.header__navbar-user');
const loginLogout = document.querySelectorAll('.header__navbar-item--strong');
const formRegister = document.querySelectorAll('.auth-form__register, .modal__overlay');
const formLogin = document.querySelectorAll('.auth-form__login, .modal__overlay');
const modalForm = document.querySelector('.modal');
const btnRegister = document.querySelector('.header__navbar-register');
const btnLogin = document.querySelector('.header__navbar-login');
const switchBottom = document.querySelectorAll('.auth-form__switch-btn');
const controlBack = document.querySelectorAll('.auth-form__control-back');
const btnQuickReview = document.querySelectorAll('.home-product-item__btn-quick-review');
const modalQuickReview = document.querySelectorAll('.quick-review , .modal__overlay')


function showRegister(){
    for (let attribute of formRegister){
        attribute.classList.add('form__active');
    }
    formLogin[1].classList.remove('form__active');
    modalForm.classList.add('form__active-modal-form');
}
btnRegister.onclick = () => {
    showRegister();
};

formRegister[0].onclick = function() {
    for (let attribute of formRegister){
        attribute.classList.remove('form__active');
    }
    modalForm.classList.remove('form__active-modal-form');
}
// show and hide form login
function showLogin(){
    for (let attribute of formLogin){
        attribute.classList.add('form__active');
    }
    formRegister[1].classList.remove('form__active');
    modalForm.classList.add('form__active-modal-form');
}
btnLogin.onclick = () => {
    showLogin();
};
formLogin[0].onclick = function() {
    for (let attribute of formLogin) {
        attribute.classList.remove('form__active');
    }
    modalForm.classList.remove('form__active-modal-form');
}

// switch Button
for (let attribute of switchBottom){
    attribute.onclick = () => {
        if(attribute.innerText == 'Đăng ký'){
            formLogin[1].classList.remove('form__active');
            formLogin[0].classList.remove('form__active');
            showRegister();
        }
        else{
            formRegister[1].classList.remove('form__active');
            formRegister[0].classList.remove('form__active');
            showLogin();
        }
    }
}
// control back
for (let attribute of controlBack){
    attribute.onclick = () => {
        formLogin[1].classList.remove('form__active');
        formLogin[0].classList.remove('form__active');
        formRegister[1].classList.remove('form__active');
        formRegister[0].classList.remove('form__active');
        modalForm.classList.remove('form__active-modal-form');
    }
}
// quick review button
// for (let attribute of btnQuickReview){
//     attribute.onclick = () => {
//         modalForm.classList.add('form__active-modal-form');
//         modalQuickReview[0].classList.add('form__active');
//         modalQuickReview[1].classList.add('form__active');
//         formRegister[1].classList.remove('form__active');
//         formLogin[1].classList.remove('form__active');
//     }
// }
modalQuickReview[0].onclick = () =>{
    modalForm.classList.remove('form__active-modal-form');
    modalQuickReview[0].classList.remove('form__active');
    modalQuickReview[1].classList.remove('form__active');
}
// slide show

var slideIndex = 1;
showSlides(slideIndex);

// Next/previous controls
function plusSlides(n) {
  showSlides(slideIndex += n);
}

// Thumbnail image controls
function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " active";
}
