class Bike:
    def __init__(self, is_moving=False, speed=0, color=""):
        self.is_moving = is_moving  
        self.speed = speed          
        self.color = color          

    def start_moving(self):
        self.is_moving = True

    def stop_moving(self):
        self.is_moving = False

    def set_speed(self, speed):
        self.speed = speed

    def set_color(self, color):
        self.color = color

    def get_info(self):
        return print(f"Info: Moving={self.is_moving}, Speed={self.speed}, Color={self.color}")


obj = Bike(is_moving=True, speed=10, color="red")

print(obj.get_info())  

obj.stop_moving()
obj.set_speed(5)
obj.set_color("blue")

print(obj.get_info())  