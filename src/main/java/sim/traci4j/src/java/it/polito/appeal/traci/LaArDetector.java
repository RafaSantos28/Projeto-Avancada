/*
    THIS FILE IS GENERATED AUTOMATICALLY. DO NOT EDIT: CHANGES WILL BE OVERWRITTEN.
    File generated by traciObject.xslt.
*/

/*   
    Copyright (C) 2013 ApPeAL Group, Politecnico di Torino

    This file is part of TraCI4J.

    TraCI4J is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    TraCI4J is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with TraCI4J.  If not, see <http://www.gnu.org/licenses/>.
*/


package sim.traci4j.src.java.it.polito.appeal.traci;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Representation of a Lane Area detector (E2) in the SUMO environment.
 *
 * @author Christian Zyweck &lt;zyweckch@informatik.hu-berlin.de&gt;
 * @see <a href="http://sumo.dlr.de/wiki/Simulation/Output/Lanearea_Detectors_(E2)">SUMO documentation</a>
 * @see <a href="http://sumo.dlr.de/wiki/TraCI/Lane_Area_Detector_Value_Retrieval">TraCI documentation</a>
 */
public class LaArDetector
        extends TraciObject<LaArDetector.Variable>
        implements StepAdvanceListener {

    /**
     * Enumerates all the read queries. Each value can be used as an argument
     * for {@link TraciObject#getReadQuery(Enum)}.
     *
     * @author Enrico Gueli &lt;enrico.gueli@polito.it&gt;
     */
    public static enum Variable {

        /**
         * Query "ReadLane"
         *
         * @see #queryReadLane
         */
        LANE,

        /**
         * Query "ReadLastStepVehicleNumber"
         *
         * @see #queryReadLastStepVehicleNumber
         */
        VEHICLE_NUMBER,

        /**
         * Query "ReadLastStepMeanSpeed"
         *
         * @see #queryReadLastStepMeanSpeed
         */
        MEAN_SPEED,

        /**
         * Query "ReadLastStepVehicles"
         *
         * @see #queryReadLastStepVehicles
         */
        VEHICLES,

        /**
         * Query "ReadPositionInLane"
         *
         * @see #queryReadPositionInLane
         */
        POSITION,

        /**
         * Query "ReadLengthInLane"
         *
         * @see #queryReadLengthInLane
         */
        LENGTH,

    }

    LaArDetector(
            DataInputStream dis,
            DataOutputStream dos,
            String id

            , Repository<Lane> repoLane
            , Repository<Vehicle> repoVehicle
    ) {
        super(id, Variable.class);

        /*
         * initialization of read queries
         */

        addReadQuery(Variable.LANE,
                new ReadObjectVarQuery.LaneQ(dis, dos,
                        sim.traci4j.src.java.it.polito.appeal.traci.protocol.Constants.CMD_GET_LANE_AREA_DETECTOR_VARIABLE
                        ,
                        id,
                        sim.traci4j.src.java.it.polito.appeal.traci.protocol.Constants.VAR_LANE_ID
                        , repoLane

                ));

        addReadQuery(Variable.VEHICLE_NUMBER,
                new ReadObjectVarQuery.IntegerQ(dis, dos,
                        sim.traci4j.src.java.it.polito.appeal.traci.protocol.Constants.CMD_GET_LANE_AREA_DETECTOR_VARIABLE
                        ,
                        id,
                        sim.traci4j.src.java.it.polito.appeal.traci.protocol.Constants.LAST_STEP_VEHICLE_NUMBER


                ));

        addReadQuery(Variable.MEAN_SPEED,
                new ReadObjectVarQuery.DoubleQ(dis, dos,
                        sim.traci4j.src.java.it.polito.appeal.traci.protocol.Constants.CMD_GET_LANE_AREA_DETECTOR_VARIABLE
                        ,
                        id,
                        sim.traci4j.src.java.it.polito.appeal.traci.protocol.Constants.LAST_STEP_MEAN_SPEED


                ));

        addReadQuery(Variable.VEHICLES,
                new VehicleSetQuery(dis, dos,
                        sim.traci4j.src.java.it.polito.appeal.traci.protocol.Constants.CMD_GET_LANE_AREA_DETECTOR_VARIABLE
                        ,
                        id,
                        sim.traci4j.src.java.it.polito.appeal.traci.protocol.Constants.LAST_STEP_VEHICLE_ID_LIST

                        , repoVehicle

                ));

        addReadQuery(Variable.POSITION,
                new ReadObjectVarQuery.DoubleQ(dis, dos,
                        sim.traci4j.src.java.it.polito.appeal.traci.protocol.Constants.CMD_GET_LANE_AREA_DETECTOR_VARIABLE
                        ,
                        id,
                        sim.traci4j.src.java.it.polito.appeal.traci.protocol.Constants.VAR_POSITION

                ));

        addReadQuery(Variable.LENGTH,
                new ReadObjectVarQuery.DoubleQ(dis, dos,
                        sim.traci4j.src.java.it.polito.appeal.traci.protocol.Constants.CMD_GET_LANE_AREA_DETECTOR_VARIABLE
                        ,
                        id,
                        sim.traci4j.src.java.it.polito.appeal.traci.protocol.Constants.VAR_LENGTH

                ));


        /*
         * initialization of change state queries
         */


    }


    public void nextStep(double step) {

        getReadQuery(Variable.VEHICLE_NUMBER).setObsolete();

        getReadQuery(Variable.MEAN_SPEED).setObsolete();

        getReadQuery(Variable.VEHICLES).setObsolete();

    }


    /**
     * @return the instance of {@link ReadObjectVarQuery} relative to this query.
     */
    public ReadObjectVarQuery<Lane> queryReadLane() {
        return (ReadObjectVarQuery.LaneQ) getReadQuery(Variable.LANE);
    }


    /**
     * Executes an instance of {@link ReadObjectVarQuery} relative to this query,
     * and returns the corresponding value.
     */
    public Lane getLane() throws IOException {
        return ((ReadObjectVarQuery.LaneQ) getReadQuery(Variable.LANE)).get();
    }

    /**
     * @return the instance of {@link ReadObjectVarQuery} relative to this query.
     */
    public ReadObjectVarQuery<Integer> queryReadLastStepVehicleNumber() {
        return (ReadObjectVarQuery.IntegerQ) getReadQuery(Variable.VEHICLE_NUMBER);
    }


    /**
     * Executes an instance of {@link ReadObjectVarQuery} relative to this query,
     * and returns the corresponding value.
     */
    public Integer getVehicleNumber() throws IOException {
        return ((ReadObjectVarQuery.IntegerQ) getReadQuery(Variable.VEHICLE_NUMBER)).get();
    }

    /**
     * @return the instance of {@link ReadObjectVarQuery} relative to this query.
     */
    public ReadObjectVarQuery<Double> queryReadLastStepMeanSpeed() {
        return (ReadObjectVarQuery.DoubleQ) getReadQuery(Variable.MEAN_SPEED);
    }


    /**
     * Executes an instance of {@link ReadObjectVarQuery} relative to this query,
     * and returns the corresponding value.
     */
    public Double getMeanSpeed() throws IOException {
        return ((ReadObjectVarQuery.DoubleQ) getReadQuery(Variable.MEAN_SPEED)).get();
    }

    /**
     * @return the instance of {@link ReadObjectVarQuery} relative to this query.
     */
    public ReadObjectVarQuery<java.util.Set<Vehicle>> queryReadLastStepVehicles() {
        return (VehicleSetQuery) getReadQuery(Variable.VEHICLES);
    }


    /**
     * Executes an instance of {@link ReadObjectVarQuery} relative to this query,
     * and returns the corresponding value.
     */
    public java.util.Set<Vehicle> getVehicles() throws IOException {
        return ((VehicleSetQuery) getReadQuery(Variable.VEHICLES)).get();
    }

    /**
     * @return the instance of {@link ReadObjectVarQuery} relative to this query.
     */
    public ReadObjectVarQuery<Double> queryReadPositionInLane() {
        return (ReadObjectVarQuery.DoubleQ) getReadQuery(Variable.POSITION);
    }


    /**
     * Executes an instance of {@link ReadObjectVarQuery} relative to this query,
     * and returns the corresponding value.
     */
    public Double getPosition() throws IOException {
        return ((ReadObjectVarQuery.DoubleQ) getReadQuery(Variable.POSITION)).get();
    }

    /**
     * @return the instance of {@link ReadObjectVarQuery} relative to this query.
     */
    public ReadObjectVarQuery<Double> queryReadLengthInLane() {
        return (ReadObjectVarQuery.DoubleQ) getReadQuery(Variable.LENGTH);
    }


    /**
     * Executes an instance of {@link ReadObjectVarQuery} relative to this query,
     * and returns the corresponding value.
     */
    public Double getLength() throws IOException {
        return ((ReadObjectVarQuery.DoubleQ) getReadQuery(Variable.LENGTH)).get();
    }

}

