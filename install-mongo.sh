cd ~/
curl -O https://fastdl.mongodb.org/linux/mongodb-linux-x86_64-3.4.9.tgz
tar -zxvf mongodb-linux-x86_64-3.4.9.tgz
sudo mkdir -p ~/mongodb/
sudo mkdir -p /data/db
sudo cp -R mongodb-linux-x86_64-3.4.9/* ~/mongodb/
sudo echo "export PATH=~/mongodb/bin:$PATH" >> ~/.bashrc