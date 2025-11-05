  // Password strength indicator
    document.getElementById('password').addEventListener('input', function() {
        const password = this.value;
        const strengthBar = document.getElementById('passwordStrength');
        let strength = 0;

        if (password.length >= 6) strength += 25;
        if (password.match(/[a-z]/) && password.match(/[A-Z]/)) strength += 25;
        if (password.match(/\d/)) strength += 25;
        if (password.match(/[^a-zA-Z\d]/)) strength += 25;

        strengthBar.className = 'password-strength';
        if (strength <= 25) {
            strengthBar.classList.add('strength-weak');
        } else if (strength <= 50) {
            strengthBar.classList.add('strength-medium');
        } else if (strength <= 75) {
            strengthBar.classList.add('strength-strong');
        } else {
            strengthBar.classList.add('strength-very-strong');
        }
    });

    // Password confirmation validation
    document.getElementById('confirmPassword').addEventListener('input', function() {
        const password = document.getElementById('password').value;
        const confirmPassword = this.value;
        const matchText = document.getElementById('passwordMatchText');

        if (confirmPassword === '') {
            matchText.textContent = '';
            this.classList.remove('is-valid', 'is-invalid');
        } else if (password === confirmPassword) {
            matchText.textContent = 'Passwords match!';
            matchText.className = 'form-text text-success';
            this.classList.add('is-valid');
            this.classList.remove('is-invalid');
        } else {
            matchText.textContent = 'Passwords do not match';
            matchText.className = 'form-text text-danger';
            this.classList.add('is-invalid');
            this.classList.remove('is-valid');
        }
    });

    // Form submission validation
    document.getElementById('registrationForm').addEventListener('submit', function(e) {
        const password = document.getElementById('password').value;
        const confirmPassword = document.getElementById('confirmPassword').value;
        const agreeToTerms = document.getElementById('agreeToTerms').checked;

        if (password !== confirmPassword) {
            e.preventDefault();
            alert('Please make sure your passwords match!');
            document.getElementById('confirmPassword').focus();
            return;
        }

        if (!agreeToTerms) {
            e.preventDefault();
            alert('You must agree to the terms and conditions!');
            document.getElementById('agreeToTerms').focus();
            return;
        }
    });

    // Real-time username availability check (simulated)
    document.getElementById('username').addEventListener('blur', function() {
        const username = this.value;
        if (username.length >= 3) {
            // In real application, you would make an AJAX call here
            console.log('Checking username availability:', username);
        }
    });