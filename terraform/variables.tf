 // we set the default values hardcoded here because these values don't change much they are most likely fixed
variable vpc_cidr_block {
    default = "10.0.0.0/16"
}
variable subnet_cidr_block {
    default = "10.0.10.0/24"
}
variable avail_zone {
    default = "eu-west-3a"
}
variable env_prefix {
    default = "dev"
}
variable my_ip {
    default = "156.223.138.179/32"
}
variable instance_type {
    default = "t2.micro"
}
variable region {
    default = "eu-west-3"
}