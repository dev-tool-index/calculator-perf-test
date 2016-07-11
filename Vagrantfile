# -*- mode: ruby -*-
# vi: set ft=ruby :

unless Vagrant.has_plugin?("vagrant-docker-compose")
  system("vagrant plugin install vagrant-docker-compose")
  puts "Dependencies installed, please try the command again."
  exit
end

# Vagrantfile API/syntax version. Don't touch unless you know what you're doing!
VAGRANTFILE_API_VERSION = "2"

# Set default provider to virtualbox
ENV['VAGRANT_DEFAULT_PROVIDER'] = 'virtualbox'

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|
  # All Vagrant configuration is done here. The most common configuration
  # options are documented and commented below. For a complete reference,
  # please see the online documentation at vagrantup.com.

  # Every Vagrant virtual environment requires a box to build off of.
  config.vm.box = "ubuntu/trusty64"

  # The url from where the 'config.vm.box' box will be fetched if it
  # doesn't already exist on the user's system.
  # config.vm.box_url = "https://atlas.hashicorp.com/ubuntu/boxes/trusty64/versions/14.04/providers/virtualbox.box"

  # Create a forwarded port mapping which allows access to a specific port
  # within the machine from a port on the host machine. In the example below,
  # accessing "localhost:8080" will access port 80 on the guest machine.
  config.vm.network :forwarded_port, guest: 8080, host: 8080, auto_correct: true
  config.vm.network :forwarded_port, guest: 5672, host: 5672, auto_correct: true
  config.vm.network :forwarded_port, guest: 15672, host: 15672, auto_correct: true
  config.vm.network :forwarded_port, guest: 27017, host: 27017, auto_correct: true
  config.vm.network :forwarded_port, guest: 28017, host: 28017, auto_correct: true
  config.vm.network :forwarded_port, guest: 8082, host: 8082, auto_correct: true
  config.vm.network :forwarded_port, guest: 8083, host: 8083, auto_correct: true

  # Create a private network, which allows host-only access to the machine
  # using a specific IP.
  config.vm.network :private_network, ip: "192.168.33.10"

  config.vm.provider "virtualbox" do |v|
    v.memory = 4096
    v.cpus = 4
  end

  config.vm.provision :docker
  config.vm.provision :docker_compose, yml: "/vagrant/docker-compose.yml", rebuild: true, project_name: "myproject", run: "always"

  config.vm.provision "shell", run: "always" do |s|
	s.path = "setup.sh"
  end
end
