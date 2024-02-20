package com.example.restcountryfx;

import com.example.restcountryfx.Models.CountryDTO;
import com.example.restcountryfx.Services.FakeRestCountriesService;
import javafx.beans.Observable;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class RestCountriesController {
    @FXML
    public ComboBox comboRegions;
    @FXML
    public TableView<CountryDTO> tableCountry;
    @FXML
    public TableColumn<CountryDTO,String> countryNameColum;
    @FXML
    public ImageView imgFlag;
    @FXML
    public TextField txtCountry;
    @FXML
    public TextField txtCapital;
    @FXML
    public TextField txtPoblation;
    @FXML
    public TextField txtCoin;
    @FXML
    public Button btnClear;

    ObservableList<CountryDTO> observableList = FXCollections.observableArrayList();

    @FXML
    public void BtnClear() {
        txtPoblation.setText("");
        txtCountry.setText("");
        txtCoin.setText("");
        txtCapital.setText("");
        imgFlag.setImage(null);
        comboRegions.getSelectionModel().clearSelection();
        observableList.clear();
    }
    @FXML
    public void initialize(){
        countryNameColum.setCellValueFactory(celldata -> new SimpleObjectProperty<>(celldata.getValue().getName()));
        FakeRestCountriesService fakeRestCountriesService = new FakeRestCountriesService();
        comboRegions.getItems().addAll(fakeRestCountriesService.getRegions());
        tableCountry.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 1) {
                    String country = tableCountry.getSelectionModel().getSelectedItem().getName();
                    CountryDTO country1 = fakeRestCountriesService.getCountryByName(country);
                    txtCapital.setText(country1.getCapital());
                    txtCountry.setText(country1.getName());
                    txtCoin.setText(country1.getCoin());
                    txtPoblation.setText(String.valueOf(country1.getPopulation()));
                }
            }
        });

        comboRegions.setOnAction(event -> {
            if (comboRegions.getSelectionModel().getSelectedItem().toString()!=null) {
                String selected = comboRegions.getSelectionModel().getSelectedItem().toString();
                observableList.clear();
                observableList.addAll(fakeRestCountriesService.getCountriesByRegions(selected));
                tableCountry.setItems(observableList);
                //imgFlag.setImage(new Image("https://flagcdn.com/w320/es.png"));
            }
            //System.out.println("Elemento seleccionado: " + selected);
        });
    }
}