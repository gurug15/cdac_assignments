#include<iostream>
class Base {
        public:
            virtual void show() { std::cout << "Base\n"; }
        };
        
        class Derived : public Base {
        public:
            void show() override { std::cout << "Derived\n"; }
        };
        
        void print(Base obj) {  // Passed by value (Slicing happens)
            obj.show(); // Always calls Base::show()
        }
        
        void printRef(Base& obj) {  // Passed by reference (No slicing)
            obj.show(); // Calls Derived::show() if a Derived object is passed
        }
        
        int main() {
            Derived d;
            print(d);  // Output: Base (Slicing issue)
            printRef(d); // Output: Derived (Correct behavior)
        }
        