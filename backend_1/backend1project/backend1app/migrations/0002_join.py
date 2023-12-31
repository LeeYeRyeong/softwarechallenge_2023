# Generated by Django 4.2.3 on 2023-08-15 09:16

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('backend1app', '0001_initial'),
    ]

    operations = [
        migrations.CreateModel(
            name='Join',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(default='name', max_length=10)),
                ('number', models.IntegerField(default='number', max_length=8)),
                ('major', models.CharField(default='major', max_length=20)),
                ('email', models.EmailField(default='email', max_length=50)),
                ('password', models.CharField(default='password', max_length=20)),
                ('passwordCheck', models.CharField(default='passwordCheck', max_length=20)),
            ],
        ),
    ]
