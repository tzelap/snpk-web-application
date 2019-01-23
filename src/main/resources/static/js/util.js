$('.profile-link').click(function() {
    if($('.profile-dropdown').css('display') === 'block')
    {
        $('.profile-dropdown').css('display', 'none');
    } else {
        $('.profile-dropdown').css('display', 'block');
    }
});
if($('form.loginForm').length){
    $('.loginForm')[0].reset();
};
