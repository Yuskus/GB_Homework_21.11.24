# Алгоритмы и структуры данных  

### Домашнее задание 1:  

**Задача 1:** Вам дан список задач, каждая из которых имеет приоритет (целое число).
Напишите функцию sortTasksByPriority, которая сортирует задачи по убыванию приоритета с использованием сортировки кучей (HeapSort).  

**Задача 2:** Напишите функцию sortPhoneNumbers, которая сортирует номера телефонов в порядке возрастания с использованием поразрядной сортировки (RadixSort).  

**Задача 3:** Напишите функцию countLetters, которая подсчитывает количество каждой буквы в строке и выводит их по порядку в алфавите.
Функция должна игнорировать регистр букв.  

### Домашнее задание 2:  

**Задача 1:** Удаление дубликатов в односвязном списке. Напишите метод, который удаляет все дубликаты из односвязного списка.  

**Задача 2:** Реализуйте метод, который находит средний элемент односвязного списка за один проход по нему.  

**Задача 3:** Реализуйте метод, который сливает два отсортированных односвязных списка в один отсортированный список.  

### Домашнее задание 3:  

**Задача 1:** Вам дано бинарное дерево поиска.
Напишите метод, который преобразует его в левостороннее красно-черное дерево (РЧД).

Красно-черное дерево должно удовлетворять следующим критериям:  
1. Каждая нода имеет цвет (красный или черный).  
2. Корень дерева всегда черный.  
3. Новая нода всегда красная.  
4. Красные ноды могут быть только левыми дочерними элементами.  
5. Украсной ноды все дочерние элементы черного цвета.

Для этого, реализуйте методы добавления новых элементов с балансировкой и выполняйте следующие операции для поддержания свойств РЧД:  
* Левый малый поворот  
* Правый малый поворот  
* Смена цвета  

Критерии применения этих операций:  
* Если правый дочерний элемент красный, а левый черный, то применяем малый правый поворот.  
* Если левый дочерний элемент красный и его левый дочерний элемент тоже красный, то применяем малый левый поворот.  
* Если оба дочерних элемента красные, то делаем смену цвета.  
* Если корень стал красным, то перекрашиваем его в черный.  
