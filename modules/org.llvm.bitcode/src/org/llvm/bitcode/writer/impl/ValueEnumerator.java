/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */

package org.llvm.bitcode.writer.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;

//<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 44,
 FQN="llvm::ValueEnumerator", NM="_ZN4llvm15ValueEnumeratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15ValueEnumeratorE")
//</editor-fold>
public class ValueEnumerator implements Destructors.ClassWithDestructor {
/*public:*/
  /*typedef std::vector<Type *> TypeList*/
//  public final class TypeList extends std.vector<Type /*P*/ >{ };
  
  // For each value, we remember its Value* and occurrence frequency.
  /*typedef std::vector<std::pair<const Value *, unsigned int> > ValueList*/
//  public final class ValueList extends std.vector<std.pairTypeUInt</*const*/ Value /*P*/ >>{ };
  
  public std.vector<UseListOrder> UseListOrders;
/*private:*/
  /*typedef DenseMap<Type *, unsigned int> TypeMapType*/
//  public final class TypeMapType extends DenseMapTypeUInt<Type /*P*/ >{ };
  private DenseMapTypeUInt<Type /*P*/ > TypeMap;
  private std.vector<Type /*P*/ > Types;
  
  /*typedef DenseMap<const Value *, unsigned int> ValueMapType*/
//  public final class ValueMapType extends DenseMapTypeUInt</*const*/ Value /*P*/ >{ };
  private DenseMapTypeUInt</*const*/ Value /*P*/ > ValueMap;
  private std.vector<std.pairTypeUInt</*const*/ Value /*P*/ >> Values;
  
  /*typedef UniqueVector<const Comdat *> ComdatSetType*/
//  public final class ComdatSetType extends UniqueVector</*const*/ Comdat /*P*/ >{ };
  private UniqueVector</*const*/ Comdat /*P*/ > Comdats;
  
  private std.vector</*const*/ Metadata /*P*/ > MDs;
  private std.vector</*const*/ Metadata /*P*/ > FunctionMDs;
  
  /// Index of information about a piece of metadata.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::MDIndex">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 69,
   FQN="llvm::ValueEnumerator::MDIndex", NM="_ZN4llvm15ValueEnumerator7MDIndexE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15ValueEnumerator7MDIndexE")
  //</editor-fold>
  private static class/*struct*/ MDIndex {
    public /*uint*/int F/* = 0*/; ///< The ID of the function for this metadata, if any.
    public /*uint*/int ID/* = 0*/; ///< The implicit ID of this metadata in bitcode.
    
    //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::MDIndex::MDIndex">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 73,
     FQN="llvm::ValueEnumerator::MDIndex::MDIndex", NM="_ZN4llvm15ValueEnumerator7MDIndexC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15ValueEnumerator7MDIndexC1Ev")
    //</editor-fold>
    public MDIndex() {
      // : F(0), ID(0)/* = default*/ 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::MDIndex::MDIndex">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 74,
     FQN="llvm::ValueEnumerator::MDIndex::MDIndex", NM="_ZN4llvm15ValueEnumerator7MDIndexC1Ej",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15ValueEnumerator7MDIndexC1Ej")
    //</editor-fold>
    public /*explicit*/ MDIndex(/*uint*/int F) {
      // : F(F), ID(0) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Check if this has a function tag, and it's different from NewF.
    //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::MDIndex::hasDifferentFunction">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 77,
     FQN="llvm::ValueEnumerator::MDIndex::hasDifferentFunction", NM="_ZNK4llvm15ValueEnumerator7MDIndex20hasDifferentFunctionEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm15ValueEnumerator7MDIndex20hasDifferentFunctionEj")
    //</editor-fold>
    public boolean hasDifferentFunction(/*uint*/int NewF) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Fetch the MD this references out of the given metadata array.
    //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::MDIndex::get">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 80,
     FQN="llvm::ValueEnumerator::MDIndex::get", NM="_ZNK4llvm15ValueEnumerator7MDIndex3getENS_8ArrayRefIPKNS_8MetadataEEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm15ValueEnumerator7MDIndex3getENS_8ArrayRefIPKNS_8MetadataEEE")
    //</editor-fold>
    public /*const*/ Metadata /*P*/ get(ArrayRef</*const*/ Metadata /*P*/ > MDs) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::MDIndex::MDIndex">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 69,
     FQN="llvm::ValueEnumerator::MDIndex::MDIndex", NM="_ZN4llvm15ValueEnumerator7MDIndexC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15ValueEnumerator7MDIndexC1ERKS1_")
    //</editor-fold>
    public /*inline*/ MDIndex(/*const*/ MDIndex /*&*/ $Prm0) {
      // : F(.F), ID(.ID) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::MDIndex::MDIndex">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 69,
     FQN="llvm::ValueEnumerator::MDIndex::MDIndex", NM="_ZN4llvm15ValueEnumerator7MDIndexC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15ValueEnumerator7MDIndexC1EOS1_")
    //</editor-fold>
    public /*inline*/ MDIndex(JD$Move _dparam, MDIndex /*&&*/$Prm0) {
      // : F(static_cast<MDIndex &&>().F), ID(static_cast<MDIndex &&>().ID) 
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::MDIndex::operator=">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 69,
     FQN="llvm::ValueEnumerator::MDIndex::operator=", NM="_ZN4llvm15ValueEnumerator7MDIndexaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZN4llvm15ValueEnumerator7MDIndexaSEOS1_")
    //</editor-fold>
    public /*inline*/ MDIndex /*&*/ $assignMove(MDIndex /*&&*/$Prm0) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "F=" + F // NOI18N
                + ", ID=" + ID; // NOI18N
    }
  };
  
  /*typedef DenseMap<const Metadata *, MDIndex> MetadataMapType*/
//  public final class MetadataMapType extends DenseMap</*const*/ Metadata /*P*/ , MDIndex>{ };
  private DenseMap</*const*/ Metadata /*P*/ , MDIndex> MetadataMap;
  
  /// Range of metadata IDs, as a half-open range.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::MDRange">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 91,
   FQN="llvm::ValueEnumerator::MDRange", NM="_ZN4llvm15ValueEnumerator7MDRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15ValueEnumerator7MDRangeE")
  //</editor-fold>
  private static class/*struct*/ MDRange {
    public /*uint*/int First/* = 0*/;
    public /*uint*/int Last/* = 0*/;
    
    /// Number of strings in the prefix of the metadata range.
    public /*uint*/int NumStrings/* = 0*/;
    //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::MDRange::MDRange">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 98,
     FQN="llvm::ValueEnumerator::MDRange::MDRange", NM="_ZN4llvm15ValueEnumerator7MDRangeC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZN4llvm15ValueEnumerator7MDRangeC1Ev")
    //</editor-fold>
    public MDRange() {
      // : First(0), Last(0), NumStrings(0)/* = default*/ 
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::MDRange::MDRange">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 99,
     FQN="llvm::ValueEnumerator::MDRange::MDRange", NM="_ZN4llvm15ValueEnumerator7MDRangeC1Ej",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15ValueEnumerator7MDRangeC1Ej")
    //</editor-fold>
    public /*explicit*/ MDRange(/*uint*/int First) {
      // : First(First), Last(0), NumStrings(0) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::MDRange::MDRange">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 91,
     FQN="llvm::ValueEnumerator::MDRange::MDRange", NM="_ZN4llvm15ValueEnumerator7MDRangeC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15ValueEnumerator7MDRangeC1ERKS1_")
    //</editor-fold>
    public /*inline*/ MDRange(/*const*/ MDRange /*&*/ $Prm0) {
      // : First(.First), Last(.Last), NumStrings(.NumStrings) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::MDRange::MDRange">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 91,
     FQN="llvm::ValueEnumerator::MDRange::MDRange", NM="_ZN4llvm15ValueEnumerator7MDRangeC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15ValueEnumerator7MDRangeC1EOS1_")
    //</editor-fold>
    public /*inline*/ MDRange(JD$Move _dparam, MDRange /*&&*/$Prm0) {
      // : First(static_cast<MDRange &&>().First), Last(static_cast<MDRange &&>().Last), NumStrings(static_cast<MDRange &&>().NumStrings) 
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::MDRange::operator=">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 91,
     FQN="llvm::ValueEnumerator::MDRange::operator=", NM="_ZN4llvm15ValueEnumerator7MDRangeaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZN4llvm15ValueEnumerator7MDRangeaSERKS1_")
    //</editor-fold>
    public /*inline*/ MDRange /*&*/ $assign(/*const*/ MDRange /*&*/ $Prm0) {
      throw new UnsupportedOperationException("EmptyBody");
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::MDRange::operator=">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 91,
     FQN="llvm::ValueEnumerator::MDRange::operator=", NM="_ZN4llvm15ValueEnumerator7MDRangeaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZN4llvm15ValueEnumerator7MDRangeaSEOS1_")
    //</editor-fold>
    public /*inline*/ MDRange /*&*/ $assignMove(MDRange /*&&*/$Prm0) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "First=" + First // NOI18N
                + ", Last=" + Last // NOI18N
                + ", NumStrings=" + NumStrings; // NOI18N
    }
  };
  private SmallDenseMapUIntType<MDRange> FunctionMDInfo;
  
  private boolean ShouldPreserveUseListOrder;
  
  /*typedef DenseMap<AttributeSet, unsigned int> AttributeGroupMapType*/
//  public final class AttributeGroupMapType extends DenseMapTypeUInt<AttributeSet>{ };
  private DenseMapTypeUInt<AttributeSet> AttributeGroupMap;
  private std.vector<AttributeSet> AttributeGroups;
  
  /*typedef DenseMap<AttributeSet, unsigned int> AttributeMapType*/
//  public final class AttributeMapType extends DenseMapTypeUInt<AttributeSet>{ };
  private DenseMapTypeUInt<AttributeSet> AttributeMap;
  private std.vector<AttributeSet> Attribute;
  
  /// GlobalBasicBlockIDs - This map memoizes the basic block ID's referenced by
  /// the "getGlobalBasicBlockID" method.
  private /*mutable */DenseMapTypeUInt</*const*/ BasicBlock /*P*/ > GlobalBasicBlockIDs;
  
  /*typedef DenseMap<const Instruction *, unsigned int> InstructionMapType*/
//  public final class InstructionMapType extends DenseMapTypeUInt</*const*/ Instruction /*P*/ >{ };
  private DenseMapTypeUInt</*const*/ Instruction /*P*/ > InstructionMap;
  private /*uint*/int InstructionCount;
  
  /// BasicBlocks - This contains all the basic blocks for the currently
  /// incorporated function.  Their reverse mapping is stored in ValueMap.
  private std.vector</*const*/ BasicBlock /*P*/ > BasicBlocks;
  
  /// When a function is incorporated, this is the size of the Values list
  /// before incorporation.
  private /*uint*/int NumModuleValues;
  
  /// When a function is incorporated, this is the size of the Metadatas list
  /// before incorporation.
  private /*uint*/int NumModuleMDs/* = 0*/;
  private /*uint*/int NumMDStrings/* = 0*/;
  
  private /*uint*/int FirstFuncConstantID;
  private /*uint*/int FirstInstID;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::ValueEnumerator">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 137,
   FQN="llvm::ValueEnumerator::ValueEnumerator", NM="_ZN4llvm15ValueEnumeratorC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15ValueEnumeratorC1ERKS0_")
  //</editor-fold>
  private ValueEnumerator(/*const*/ ValueEnumerator /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 138,
   FQN="llvm::ValueEnumerator::operator=", NM="_ZN4llvm15ValueEnumeratoraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15ValueEnumeratoraSERKS0_")
  //</editor-fold>
  private void $assign(/*const*/ ValueEnumerator /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::ValueEnumerator">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp", line = 290,
   FQN="llvm::ValueEnumerator::ValueEnumerator", NM="_ZN4llvm15ValueEnumeratorC1ERKNS_6ModuleEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZN4llvm15ValueEnumeratorC1ERKNS_6ModuleEb")
  //</editor-fold>
  public ValueEnumerator(/*const*/ Module /*&*/ M, 
      boolean ShouldPreserveUseListOrder) {
    // : UseListOrders(), TypeMap(), Types(), ValueMap(), Values(), Comdats(), MDs(), FunctionMDs(), MetadataMap(), FunctionMDInfo(), ShouldPreserveUseListOrder(ShouldPreserveUseListOrder), AttributeGroupMap(), AttributeGroups(), AttributeMap(), Attribute(), GlobalBasicBlockIDs(), InstructionMap(), BasicBlocks(), NumModuleMDs(0), NumMDStrings(0) 
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::dump">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp", line = 435,
   FQN="llvm::ValueEnumerator::dump", NM="_ZNK4llvm15ValueEnumerator4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZNK4llvm15ValueEnumerator4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp", line = 442,
   FQN="llvm::ValueEnumerator::print", NM="_ZNK4llvm15ValueEnumerator5printERNS_11raw_ostreamERKNS_8DenseMapIPKNS_5ValueEjNS_12DenseMapInfoIS6_EENS_6detail12DenseMapPairIS6_jEEEEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZNK4llvm15ValueEnumerator5printERNS_11raw_ostreamERKNS_8DenseMapIPKNS_5ValueEjNS_12DenseMapInfoIS6_EENS_6detail12DenseMapPairIS6_jEEEEPKc")
  //</editor-fold>
  public void print_raw_ostream_DenseMapTypeUInt$Value$C$C$P_char$ptr$C(raw_ostream /*&*/ OS, /*const*/DenseMapTypeUInt</*const*/ Value /*P*/ > /*&*/ Map, 
                                                           /*const*/char$ptr/*char P*/ Name) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp", line = 471,
   FQN="llvm::ValueEnumerator::print", NM="_ZNK4llvm15ValueEnumerator5printERNS_11raw_ostreamERKNS_8DenseMapIPKNS_8MetadataENS0_7MDIndexENS_12DenseMapInfoIS6_EENS_6detail12DenseMapPairIS6_S7_EEEEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZNK4llvm15ValueEnumerator5printERNS_11raw_ostreamERKNS_8DenseMapIPKNS_8MetadataENS0_7MDIndexENS_12DenseMapInfoIS6_EENS_6detail12DenseMapPairIS6_S7_EEEEPKc")
  //</editor-fold>
  public void print_raw_ostream_DenseMap$Metadata$MDIndex$C$C$P_char$ptr$C(raw_ostream /*&*/ OS, /*const*/ DenseMap</*const*/ Metadata /*P*/ , MDIndex> /*&*/ Map, 
                                                              /*const*/char$ptr/*char P*/ Name) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::getValueID">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp", line = 426,
   FQN="llvm::ValueEnumerator::getValueID", NM="_ZNK4llvm15ValueEnumerator10getValueIDEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZNK4llvm15ValueEnumerator10getValueIDEPKNS_5ValueE")
  //</editor-fold>
  public /*uint*/int getValueID(/*const*/ Value /*P*/ V) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::getMetadataID">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 148,
   FQN="llvm::ValueEnumerator::getMetadataID", NM="_ZNK4llvm15ValueEnumerator13getMetadataIDEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm15ValueEnumerator13getMetadataIDEPKNS_8MetadataE")
  //</editor-fold>
  public /*uint*/int getMetadataID(/*const*/ Metadata /*P*/ MD) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::getMetadataOrNullID">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 153,
   FQN="llvm::ValueEnumerator::getMetadataOrNullID", NM="_ZNK4llvm15ValueEnumerator19getMetadataOrNullIDEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm15ValueEnumerator19getMetadataOrNullIDEPKNS_8MetadataE")
  //</editor-fold>
  public /*uint*/int getMetadataOrNullID(/*const*/ Metadata /*P*/ MD) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::numMDs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 156,
   FQN="llvm::ValueEnumerator::numMDs", NM="_ZNK4llvm15ValueEnumerator6numMDsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm15ValueEnumerator6numMDsEv")
  //</editor-fold>
  public /*uint*/int numMDs() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::shouldPreserveUseListOrder">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 158,
   FQN="llvm::ValueEnumerator::shouldPreserveUseListOrder", NM="_ZNK4llvm15ValueEnumerator26shouldPreserveUseListOrderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm15ValueEnumerator26shouldPreserveUseListOrderEv")
  //</editor-fold>
  public boolean shouldPreserveUseListOrder() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::getTypeID">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 160,
   FQN="llvm::ValueEnumerator::getTypeID", NM="_ZNK4llvm15ValueEnumerator9getTypeIDEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm15ValueEnumerator9getTypeIDEPNS_4TypeE")
  //</editor-fold>
  public /*uint*/int getTypeID(Type /*P*/ T) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::getInstructionID">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp", line = 410,
   FQN="llvm::ValueEnumerator::getInstructionID", NM="_ZNK4llvm15ValueEnumerator16getInstructionIDEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZNK4llvm15ValueEnumerator16getInstructionIDEPKNS_11InstructionE")
  //</editor-fold>
  public /*uint*/int getInstructionID(/*const*/ Instruction /*P*/ Inst) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::setInstructionID">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp", line = 422,
   FQN="llvm::ValueEnumerator::setInstructionID", NM="_ZN4llvm15ValueEnumerator16setInstructionIDEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZN4llvm15ValueEnumerator16setInstructionIDEPKNS_11InstructionE")
  //</editor-fold>
  public void setInstructionID(/*const*/ Instruction /*P*/ I) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::getAttributeID">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 169,
   FQN="llvm::ValueEnumerator::getAttributeID", NM="_ZNK4llvm15ValueEnumerator14getAttributeIDENS_12AttributeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm15ValueEnumerator14getAttributeIDENS_12AttributeSetE")
  //</editor-fold>
  public /*uint*/int getAttributeID(AttributeSet PAL) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::getAttributeGroupID">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 176,
   FQN="llvm::ValueEnumerator::getAttributeGroupID", NM="_ZNK4llvm15ValueEnumerator19getAttributeGroupIDENS_12AttributeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm15ValueEnumerator19getAttributeGroupIDENS_12AttributeSetE")
  //</editor-fold>
  public /*uint*/int getAttributeGroupID(AttributeSet PAL) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getFunctionConstantRange - Return the range of values that corresponds to
  /// function-local constants.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::getFunctionConstantRange">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 185,
   FQN="llvm::ValueEnumerator::getFunctionConstantRange", NM="_ZNK4llvm15ValueEnumerator24getFunctionConstantRangeERjS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm15ValueEnumerator24getFunctionConstantRangeERjS1_")
  //</editor-fold>
  public void getFunctionConstantRange(uint$ref/*uint &*/ Start, uint$ref/*uint &*/ End) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::getValues">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 190,
   FQN="llvm::ValueEnumerator::getValues", NM="_ZNK4llvm15ValueEnumerator9getValuesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm15ValueEnumerator9getValuesEv")
  //</editor-fold>
  public /*const*/std.vector<std.pairTypeUInt</*const*/ Value /*P*/ >> /*&*/ getValues() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Check whether the current block has any metadata to emit.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::hasMDs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 193,
   FQN="llvm::ValueEnumerator::hasMDs", NM="_ZNK4llvm15ValueEnumerator6hasMDsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm15ValueEnumerator6hasMDsEv")
  //</editor-fold>
  public boolean hasMDs() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get the MDString metadata for this block.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::getMDStrings">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 196,
   FQN="llvm::ValueEnumerator::getMDStrings", NM="_ZNK4llvm15ValueEnumerator12getMDStringsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm15ValueEnumerator12getMDStringsEv")
  //</editor-fold>
  public ArrayRef</*const*/ Metadata /*P*/ > getMDStrings() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get the non-MDString metadata for this block.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::getNonMDStrings">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 201,
   FQN="llvm::ValueEnumerator::getNonMDStrings", NM="_ZNK4llvm15ValueEnumerator15getNonMDStringsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm15ValueEnumerator15getNonMDStringsEv")
  //</editor-fold>
  public ArrayRef</*const*/ Metadata /*P*/ > getNonMDStrings() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::getTypes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 205,
   FQN="llvm::ValueEnumerator::getTypes", NM="_ZNK4llvm15ValueEnumerator8getTypesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm15ValueEnumerator8getTypesEv")
  //</editor-fold>
  public /*const*/std.vector<Type /*P*/ > /*&*/ getTypes() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::getBasicBlocks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 206,
   FQN="llvm::ValueEnumerator::getBasicBlocks", NM="_ZNK4llvm15ValueEnumerator14getBasicBlocksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm15ValueEnumerator14getBasicBlocksEv")
  //</editor-fold>
  public /*const*/std.vector</*const*/ BasicBlock /*P*/ > /*&*/ getBasicBlocks() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::getAttributes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 209,
   FQN="llvm::ValueEnumerator::getAttributes", NM="_ZNK4llvm15ValueEnumerator13getAttributesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm15ValueEnumerator13getAttributesEv")
  //</editor-fold>
  public /*const*/std.vector<AttributeSet> /*&*/ getAttributes() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::getAttributeGroups">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 212,
   FQN="llvm::ValueEnumerator::getAttributeGroups", NM="_ZNK4llvm15ValueEnumerator18getAttributeGroupsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm15ValueEnumerator18getAttributeGroupsEv")
  //</editor-fold>
  public /*const*/std.vector<AttributeSet> /*&*/ getAttributeGroups() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::getComdats">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 216,
   FQN="llvm::ValueEnumerator::getComdats", NM="_ZNK4llvm15ValueEnumerator10getComdatsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm15ValueEnumerator10getComdatsEv")
  //</editor-fold>
  public /*const*/ UniqueVector</*const*/ Comdat /*P*/ > /*&*/ getComdats() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::getComdatID">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp", line = 416,
   FQN="llvm::ValueEnumerator::getComdatID", NM="_ZNK4llvm15ValueEnumerator11getComdatIDEPKNS_6ComdatE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZNK4llvm15ValueEnumerator11getComdatIDEPKNS_6ComdatE")
  //</editor-fold>
  public /*uint*/int getComdatID(/*const*/ Comdat /*P*/ C) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// getGlobalBasicBlockID - This returns the function-specific ID for the
  /// specified basic block.  This is relatively expensive information, so it
  /// should only be used by rare constructs such as address-of-label.
  
  /// getGlobalBasicBlockID - This returns the function-specific ID for the
  /// specified basic block.  This is relatively expensive information, so it
  /// should only be used by rare constructs such as address-of-label.
  
  /// getGlobalBasicBlockID - This returns the function-specific ID for the
  /// specified basic block.  This is relatively expensive information, so it
  /// should only be used by rare constructs such as address-of-label.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::getGlobalBasicBlockID">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp", line = 994,
   FQN="llvm::ValueEnumerator::getGlobalBasicBlockID", NM="_ZNK4llvm15ValueEnumerator21getGlobalBasicBlockIDEPKNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZNK4llvm15ValueEnumerator21getGlobalBasicBlockIDEPKNS_10BasicBlockE")
  //</editor-fold>
  public /*uint*/int getGlobalBasicBlockID(/*const*/ BasicBlock /*P*/ BB) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// incorporateFunction/purgeFunction - If you'd like to deal with a function,
  /// use these two methods to get its data into the ValueEnumerator!
  ///
  
  /// incorporateFunction/purgeFunction - If you'd like to deal with a function,
  /// use these two methods to get its data into the ValueEnumerator!
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::incorporateFunction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp", line = 909,
   FQN="llvm::ValueEnumerator::incorporateFunction", NM="_ZN4llvm15ValueEnumerator19incorporateFunctionERKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZN4llvm15ValueEnumerator19incorporateFunctionERKNS_8FunctionE")
  //</editor-fold>
  public void incorporateFunction(/*const*/ Function /*&*/ F) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::purgeFunction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp", line = 969,
   FQN="llvm::ValueEnumerator::purgeFunction", NM="_ZN4llvm15ValueEnumerator13purgeFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZN4llvm15ValueEnumerator13purgeFunctionEv")
  //</editor-fold>
  public void purgeFunction() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::computeBitsRequiredForTypeIndicies">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp", line = 1003,
   FQN="llvm::ValueEnumerator::computeBitsRequiredForTypeIndicies", NM="_ZNK4llvm15ValueEnumerator34computeBitsRequiredForTypeIndiciesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZNK4llvm15ValueEnumerator34computeBitsRequiredForTypeIndiciesEv")
  //</editor-fold>
  public long/*uint64_t*/ computeBitsRequiredForTypeIndicies() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*private:*/
  
  /// OptimizeConstants - Reorder constant pool for denser encoding.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::OptimizeConstants">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp", line = 486,
   FQN="llvm::ValueEnumerator::OptimizeConstants", NM="_ZN4llvm15ValueEnumerator17OptimizeConstantsEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZN4llvm15ValueEnumerator17OptimizeConstantsEjj")
  //</editor-fold>
  private void OptimizeConstants(/*uint*/int CstStart, /*uint*/int CstEnd) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Reorder the reachable metadata.
  ///
  /// This is not just an optimization, but is mandatory for emitting MDString
  /// correctly.
  
  /// Reorder the reachable metadata.
  ///
  /// This is not just an optimization, but is mandatory for emitting MDString
  /// correctly.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::organizeMetadata">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp", line = 695,
   FQN="llvm::ValueEnumerator::organizeMetadata", NM="_ZN4llvm15ValueEnumerator16organizeMetadataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZN4llvm15ValueEnumerator16organizeMetadataEv")
  //</editor-fold>
  private void organizeMetadata() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Drop the function tag from the transitive operands of the given node.
  
  /// Drop the function tag from the transitive operands of the given node.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::dropFunctionFromMetadata">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp", line = 549,
   FQN="llvm::ValueEnumerator::dropFunctionFromMetadata", NM="_ZN4llvm15ValueEnumerator24dropFunctionFromMetadataERNS_6detail12DenseMapPairIPKNS_8MetadataENS0_7MDIndexEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZN4llvm15ValueEnumerator24dropFunctionFromMetadataERNS_6detail12DenseMapPairIPKNS_8MetadataENS0_7MDIndexEEE")
  //</editor-fold>
  private void dropFunctionFromMetadata(std.pair</*const*/ Metadata /*P*/ , MDIndex> /*&*/ FirstMD) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Incorporate the function metadata.
  ///
  /// This should be called before enumerating LocalAsMetadata for the
  /// function.
  
  /// Incorporate the function metadata.
  ///
  /// This should be called before enumerating LocalAsMetadata for the
  /// function.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::incorporateFunctionMetadata">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp", line = 764,
   FQN="llvm::ValueEnumerator::incorporateFunctionMetadata", NM="_ZN4llvm15ValueEnumerator27incorporateFunctionMetadataERKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZN4llvm15ValueEnumerator27incorporateFunctionMetadataERKNS_8FunctionE")
  //</editor-fold>
  private void incorporateFunctionMetadata(/*const*/ Function /*&*/ F) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Enumerate a single instance of metadata with the given function tag.
  ///
  /// If \c MD has already been enumerated, check that \c F matches its
  /// function tag.  If not, call \a dropFunctionFromMetadata().
  ///
  /// Otherwise, mark \c MD as visited.  Assign it an ID, or just return it if
  /// it's an \a MDNode.
  
  /// Enumerate a single instance of metadata with the given function tag.
  ///
  /// If \c MD has already been enumerated, check that \c F matches its
  /// function tag.  If not, call \a dropFunctionFromMetadata().
  ///
  /// Otherwise, mark \c MD as visited.  Assign it an ID, or just return it if
  /// it's an \a MDNode.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::enumerateMetadataImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp", line = 627,
   FQN="llvm::ValueEnumerator::enumerateMetadataImpl", NM="_ZN4llvm15ValueEnumerator21enumerateMetadataImplEjPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZN4llvm15ValueEnumerator21enumerateMetadataImplEjPKNS_8MetadataE")
  //</editor-fold>
  private /*const*/ MDNode /*P*/ enumerateMetadataImpl(/*uint*/int F, /*const*/ Metadata /*P*/ MD) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::getMetadataFunctionID">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp", line = 536,
   FQN="llvm::ValueEnumerator::getMetadataFunctionID", NM="_ZNK4llvm15ValueEnumerator21getMetadataFunctionIDEPKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZNK4llvm15ValueEnumerator21getMetadataFunctionIDEPKNS_8FunctionE")
  //</editor-fold>
  private /*uint*/int getMetadataFunctionID(/*const*/ Function /*P*/ F) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Enumerate reachable metadata in (almost) post-order.
  ///
  /// Enumerate all the metadata reachable from MD.  We want to minimize the
  /// cost of reading bitcode records, and so the primary consideration is that
  /// operands of uniqued nodes are resolved before the nodes are read.  This
  /// avoids re-uniquing them on the context and factors away RAUW support.
  ///
  /// This algorithm guarantees that subgraphs of uniqued nodes are in
  /// post-order.  Distinct subgraphs reachable only from a single uniqued node
  /// will be in post-order.
  ///
  /// \note The relative order of a distinct and uniqued node is irrelevant.
  /// \a organizeMetadata() will later partition distinct nodes ahead of
  /// uniqued ones.
  ///{
  
  /// Enumerate reachable metadata in (almost) post-order.
  ///
  /// Enumerate all the metadata reachable from MD.  We want to minimize the
  /// cost of reading bitcode records, and so the primary consideration is that
  /// operands of uniqued nodes are resolved before the nodes are read.  This
  /// avoids re-uniquing them on the context and factors away RAUW support.
  ///
  /// This algorithm guarantees that subgraphs of uniqued nodes are in
  /// post-order.  Distinct subgraphs reachable only from a single uniqued node
  /// will be in post-order.
  ///
  /// \note The relative order of a distinct and uniqued node is irrelevant.
  /// \a organizeMetadata() will later partition distinct nodes ahead of
  /// uniqued ones.
  ///{
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::EnumerateMetadata">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp", line = 540,
   FQN="llvm::ValueEnumerator::EnumerateMetadata", NM="_ZN4llvm15ValueEnumerator17EnumerateMetadataEPKNS_8FunctionEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZN4llvm15ValueEnumerator17EnumerateMetadataEPKNS_8FunctionEPKNS_8MetadataE")
  //</editor-fold>
  private void EnumerateMetadata(/*const*/ Function /*P*/ F, /*const*/ Metadata /*P*/ MD) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::EnumerateMetadata">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp", line = 579,
   FQN="llvm::ValueEnumerator::EnumerateMetadata", NM="_ZN4llvm15ValueEnumerator17EnumerateMetadataEjPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZN4llvm15ValueEnumerator17EnumerateMetadataEjPKNS_8MetadataE")
  //</editor-fold>
  private void EnumerateMetadata(/*uint*/int F, /*const*/ Metadata /*P*/ MD) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  ///}
  ///}
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::EnumerateFunctionLocalMetadata">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp", line = 544,
   FQN="llvm::ValueEnumerator::EnumerateFunctionLocalMetadata", NM="_ZN4llvm15ValueEnumerator30EnumerateFunctionLocalMetadataERKNS_8FunctionEPKNS_15LocalAsMetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZN4llvm15ValueEnumerator30EnumerateFunctionLocalMetadataERKNS_8FunctionEPKNS_15LocalAsMetadataE")
  //</editor-fold>
  private void EnumerateFunctionLocalMetadata(/*const*/ Function /*&*/ F, /*const*/ LocalAsMetadata /*P*/ Local) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// EnumerateFunctionLocalMetadataa - Incorporate function-local metadata
  /// information reachable from the metadata.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::EnumerateFunctionLocalMetadata">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp", line = 661,
   FQN="llvm::ValueEnumerator::EnumerateFunctionLocalMetadata", NM="_ZN4llvm15ValueEnumerator30EnumerateFunctionLocalMetadataEjPKNS_15LocalAsMetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZN4llvm15ValueEnumerator30EnumerateFunctionLocalMetadataEjPKNS_15LocalAsMetadataE")
  //</editor-fold>
  private void EnumerateFunctionLocalMetadata(/*uint*/int F, /*const*/ LocalAsMetadata /*P*/ Local) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::EnumerateNamedMDNode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp", line = 531,
   FQN="llvm::ValueEnumerator::EnumerateNamedMDNode", NM="_ZN4llvm15ValueEnumerator20EnumerateNamedMDNodeEPKNS_11NamedMDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZN4llvm15ValueEnumerator20EnumerateNamedMDNodeEPKNS_11NamedMDNodeE")
  //</editor-fold>
  private void EnumerateNamedMDNode(/*const*/ NamedMDNode /*P*/ MD) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::EnumerateValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp", line = 773,
   FQN="llvm::ValueEnumerator::EnumerateValue", NM="_ZN4llvm15ValueEnumerator14EnumerateValueEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZN4llvm15ValueEnumerator14EnumerateValueEPKNS_5ValueE")
  //</editor-fold>
  private void EnumerateValue(/*const*/ Value /*P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::EnumerateType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp", line = 823,
   FQN="llvm::ValueEnumerator::EnumerateType", NM="_ZN4llvm15ValueEnumerator13EnumerateTypeEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZN4llvm15ValueEnumerator13EnumerateTypeEPNS_4TypeE")
  //</editor-fold>
  private void EnumerateType(Type /*P*/ Ty) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  // Enumerate the types for the specified value.  If the value is a constant,
  // walk through it, enumerating the types of the constant.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::EnumerateOperandType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp", line = 861,
   FQN="llvm::ValueEnumerator::EnumerateOperandType", NM="_ZN4llvm15ValueEnumerator20EnumerateOperandTypeEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZN4llvm15ValueEnumerator20EnumerateOperandTypeEPKNS_5ValueE")
  //</editor-fold>
  private void EnumerateOperandType(/*const*/ Value /*P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::EnumerateAttributes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp", line = 887,
   FQN="llvm::ValueEnumerator::EnumerateAttributes", NM="_ZN4llvm15ValueEnumerator19EnumerateAttributesENS_12AttributeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZN4llvm15ValueEnumerator19EnumerateAttributesENS_12AttributeSetE")
  //</editor-fold>
  private void EnumerateAttributes(AttributeSet PAL) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// EnumerateValueSymbolTable - Insert all of the values in the specified symbol
  /// table into the values table.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::EnumerateValueSymbolTable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp", line = 518,
   FQN="llvm::ValueEnumerator::EnumerateValueSymbolTable", NM="_ZN4llvm15ValueEnumerator25EnumerateValueSymbolTableERKNS_16ValueSymbolTableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZN4llvm15ValueEnumerator25EnumerateValueSymbolTableERKNS_16ValueSymbolTableE")
  //</editor-fold>
  private void EnumerateValueSymbolTable(/*const*/ ValueSymbolTable /*&*/ VST) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Insert all of the values referenced by named metadata in the specified
  /// module.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::EnumerateNamedMetadata">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp", line = 526,
   FQN="llvm::ValueEnumerator::EnumerateNamedMetadata", NM="_ZN4llvm15ValueEnumerator22EnumerateNamedMetadataERKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.cpp -nm=_ZN4llvm15ValueEnumerator22EnumerateNamedMetadataERKNS_6ModuleE")
  //</editor-fold>
  private void EnumerateNamedMetadata(/*const*/ Module /*&*/ M) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ValueEnumerator::~ValueEnumerator">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/ValueEnumerator.h", line = 44,
   FQN="llvm::ValueEnumerator::~ValueEnumerator", NM="_ZN4llvm15ValueEnumeratorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15ValueEnumeratorD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "UseListOrders=" + UseListOrders // NOI18N
              + ", TypeMap=" + TypeMap // NOI18N
              + ", Types=" + Types // NOI18N
              + ", ValueMap=" + ValueMap // NOI18N
              + ", Values=" + Values // NOI18N
              + ", Comdats=" + Comdats // NOI18N
              + ", MDs=" + MDs // NOI18N
              + ", FunctionMDs=" + FunctionMDs // NOI18N
              + ", MetadataMap=" + MetadataMap // NOI18N
              + ", FunctionMDInfo=" + FunctionMDInfo // NOI18N
              + ", ShouldPreserveUseListOrder=" + ShouldPreserveUseListOrder // NOI18N
              + ", AttributeGroupMap=" + AttributeGroupMap // NOI18N
              + ", AttributeGroups=" + AttributeGroups // NOI18N
              + ", AttributeMap=" + AttributeMap // NOI18N
              + ", Attribute=" + Attribute // NOI18N
              + ", GlobalBasicBlockIDs=" + GlobalBasicBlockIDs // NOI18N
              + ", InstructionMap=" + InstructionMap // NOI18N
              + ", InstructionCount=" + InstructionCount // NOI18N
              + ", BasicBlocks=" + BasicBlocks // NOI18N
              + ", NumModuleValues=" + NumModuleValues // NOI18N
              + ", NumModuleMDs=" + NumModuleMDs // NOI18N
              + ", NumMDStrings=" + NumMDStrings // NOI18N
              + ", FirstFuncConstantID=" + FirstFuncConstantID // NOI18N
              + ", FirstInstID=" + FirstInstID; // NOI18N
  }
}
