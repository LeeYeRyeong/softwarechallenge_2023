from rest_framework import serializers
from backend1app.models import Test
from backend1app.models import Join

class TestSerializer(serializers.ModelSerializer):
    class Meta:
        model=Test
        fields=('test','id')


class JoinSerializer(serializers.ModelSerializer):
    class Meta:
        model=Join
        fields=('name','number','major','email','password','passwordCheck')

class LoginSerializer(serializers.ModelSerializer):
    class Meta:
        model=Join
        fields=('email','password')
