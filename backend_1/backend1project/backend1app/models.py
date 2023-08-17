from django.db import models

class Test(models.Model):
    test=models.CharField(max_length=10)

    def __str__(self):
        return self.test
    

class Join(models.Model):
    name=models.CharField(default='name',max_length=10)
    number=models.IntegerField(default='number',max_length=8)
    major=models.CharField(default='major',max_length=20)
    email=models.EmailField(default='email',max_length=50)
    password=models.CharField(default='password',max_length=20)
    passwordCheck=models.CharField(default='passwordCheck',max_length=20)


class Login(models.Model):
    email=models.EmailField(default='email',max_length=50)
    password=models.CharField(default='password',max_length=20)

# Create your models here.
