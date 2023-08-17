from django.shortcuts import render

from rest_framework import viewsets

from backend1app.models import Test, Join, Login
from backend1app.serializers import TestSerializer, JoinSerializer, LoginSerializer

class TestViewSet(viewsets.ModelViewSet):
    queryset=Test.objects.all()
    serializer_class=TestSerializer


class JoinViewSet(viewsets.ModelViewSet):
    queryset=Join.objects.all()
    serializer_class=JoinSerializer

class Login():
    queryset=Login.objects.all()
    serializer_class=LoginSerializer
# Create your views here.
