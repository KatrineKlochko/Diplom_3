package ru.yandex.practicum.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.practicum.MainPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConstructorTests extends BaseUITest{

    @Test
    @DisplayName("Переход в раздел 'Булки'")
    @Description("Проверка возможности перехода в раздел 'Булки'")
    public void bunsTabTest() {
        MainPage main = new MainPage(driver, wait);

        main.clickSousButton();
        main.clickBunButton();
        main.waitForActiveTab("Булки");

        assertEquals("Булки", main.getActiveTabText());
    }

    @Test
    @DisplayName("Переход в раздел 'Соусы'")
    @Description("Проверка возможности перехода в раздел 'Соусы'")
    public void saucesTabTest() {
        MainPage main = new MainPage(driver, wait);

        main.clickSousButton();
        main.waitForActiveTab("Соусы");

        assertEquals("Соусы", main.getActiveTabText());
    }

    @Test
    @DisplayName("Переход в раздел 'Начинки'")
    @Description("Проверка возможности перехода в раздел 'Начинки'")
    public void fillingsTabTest() {
        MainPage main = new MainPage(driver, wait);

        main.clickFillingButton();
        main.waitForActiveTab("Начинки");

        assertEquals("Начинки", main.getActiveTabText());
    }

    @Test
    @DisplayName("Список ингредиентов 'Булки' отображается при переходе на вкладку 'Булки'")
    @Description("Проверка отображения списка с ингредиентами при переходе на вкладку 'Булки'")
    public void bunsIngredientsVisibleTest() {
        MainPage main = new MainPage(driver, wait);

        main.clickSousButton();
        main.clickBunButton();

        assertTrue(
                "Список булок не отображается",
                main.isBunsIngredientsVisible()
        );
    }

    @Test
    @DisplayName("Список ингредиентов 'Соусы' отображается при переходе на вкладку 'Соусы'")
    @Description("Проверка отображения списка с ингредиентами при переходе на вкладку 'Соусы'")
    public void saucesIngredientsVisibleTest() {
        MainPage main = new MainPage(driver, wait);

        main.clickSousButton();

        assertTrue(
                "Список соусов не отображается",
                main.isSousIngredientsVisible()
        );
    }

    @Test
    @DisplayName("Список ингредиентов 'Начинки' отображается при переходе на вкладку 'Начинки'")
    @Description("Проверка отображения списка с ингредиентами при переходе на вкладку 'Начинки'")
    public void fillingsIngredientsVisibleTest() {
        MainPage main = new MainPage(driver, wait);

        main.clickFillingButton();

        assertTrue(
                "Список начинок не отображается",
                main.isFillingIngredientsVisible()
        );
    }

}
