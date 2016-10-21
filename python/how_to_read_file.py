#! /usr/bin/env python

import os
TEMPLATE_FILE = "template_file"
DEV_FILE = "dev_file"

def compileDev():
    f = open(TEMPLATE_FILE)
    template = f.read()
    f.close()
    #read file by line

    f = open(DEV_FILE)
    line = f.readline()
    while line:
        line = line.strip('\n')
        params = line.split(",")

        change_number_list = "input".join(params[4:])
        template_exec = template % (params[0], params[1], change_number_list, params[2], params[3])
        print template_exec
        os.system(template_exec)
        line = f.readline()
    f.close()


if __name__ == '__main__':
    compileDev()
