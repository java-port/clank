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

package org.llvm.support.yaml;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import org.clank.support.aliases.type$iterator;
import org.llvm.support.java.MappingSequenceInterface;


/// \brief This is an iterator abstraction over YAML collections shared by both
///        sequences and maps.
///
/// BaseT must have a ValueT* member named CurrentEntry and a member function
/// increment() which must set CurrentEntry to 0 to create an end iterator.
/*template <class BaseT, class ValueT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::basic_collection_iterator">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 305,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 306,
 FQN="llvm::yaml::basic_collection_iterator", NM="_ZN4llvm4yaml25basic_collection_iteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml25basic_collection_iteratorE")
//</editor-fold>
public class basic_collection_iterator</*class*/ BaseT extends MappingSequenceInterface, /*class*/ ValueT extends Node>  
        implements /*public*/ std.iterator<std.input_iterator_tag, ValueT>, Native.NativeComparable, type$iterator<basic_collection_iterator, ValueT> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::basic_collection_iterator::basic_collection_iterator<BaseT, ValueT>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 309,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 310,
   FQN="llvm::yaml::basic_collection_iterator::basic_collection_iterator<BaseT, ValueT>", NM="_ZN4llvm4yaml25basic_collection_iteratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml25basic_collection_iteratorC1Ev")
  //</editor-fold>
  public basic_collection_iterator() {
    // : Base(null) 
    //START JInit
    this.Base = /*ParenListExpr*/null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::basic_collection_iterator::basic_collection_iterator<BaseT, ValueT>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 310,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 311,
   FQN="llvm::yaml::basic_collection_iterator::basic_collection_iterator<BaseT, ValueT>", NM="_ZN4llvm4yaml25basic_collection_iteratorC1EPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml25basic_collection_iteratorC1EPT_")
  //</editor-fold>
  public basic_collection_iterator(BaseT /*P*/ B) {
    // : Base(B) 
    //START JInit
    this.Base = /*ParenListExpr*/B;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::basic_collection_iterator::operator->">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 312,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 313,
   FQN="llvm::yaml::basic_collection_iterator::operator->", NM="_ZNK4llvm4yaml25basic_collection_iteratorptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZNK4llvm4yaml25basic_collection_iteratorptEv")
  //</editor-fold>
  public ValueT /*P*/ $arrow() /*const*/ {
    assert Native.$bool(Native.$bool(Base) && Native.$bool(Base.getCurrentEntry())) : "Attempted to access end iterator!";
    return (ValueT)Base.getCurrentEntry();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::basic_collection_iterator::operator*">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 317,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 318,
   FQN="llvm::yaml::basic_collection_iterator::operator*", NM="_ZNK4llvm4yaml25basic_collection_iteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZNK4llvm4yaml25basic_collection_iteratordeEv")
  //</editor-fold>
  public ValueT /*&*/ $star() /*const*/ {
    assert Native.$bool(Native.$bool(Base) && Native.$bool(Base.getCurrentEntry())) : "Attempted to dereference end iterator!";
    return (ValueT)$Deref(Base.getCurrentEntry());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::basic_collection_iterator::operator type-parameter-0-1 * ">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 323,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 324,
   FQN="llvm::yaml::basic_collection_iterator::operator type-parameter-0-1 * ", NM="_ZNK4llvm4yaml25basic_collection_iteratorcvPT0_Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZNK4llvm4yaml25basic_collection_iteratorcvPT0_Ev")
  //</editor-fold>
  public ValueT /*P*/ $T1$P() /*const*/ {
    assert Native.$bool(Native.$bool(Base) && Native.$bool(Base.getCurrentEntry())) : "Attempted to access end iterator!";
    return (ValueT)Base.getCurrentEntry();
  }

  
  /// Note on EqualityComparable:
  ///
  /// The iterator is not re-entrant,
  /// it is meant to be used for parsing YAML on-demand
  /// Once iteration started - it can point only to one entry at a time
  /// hence Base.CurrentEntry and Other.Base.CurrentEntry are equal
  /// iff Base and Other.Base are equal.
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::basic_collection_iterator::operator==">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 335,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 336,
   FQN="llvm::yaml::basic_collection_iterator::operator==", NM="_ZNK4llvm4yaml25basic_collection_iteratoreqERKNS0_25basic_collection_iteratorIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZNK4llvm4yaml25basic_collection_iteratoreqERKNS0_25basic_collection_iteratorIT_T0_EE")
  //</editor-fold>
  public boolean $eq(Object o) /*const*/ {
    basic_collection_iterator<BaseT, ValueT> /*&*/ Other = (basic_collection_iterator<BaseT, ValueT> /*&*/) o;
    if (Native.$bool(Base) && Native.$bool((Native.$eq(Base, Other.Base)))) {
      assert Native.$bool((Native.$eq(Base.getCurrentEntry(), Other.Base.getCurrentEntry()))) : "Equal Bases expected to point to equal Entries";
    }
    
    return Native.$eq(Base, Other.Base);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::basic_collection_iterator::operator!=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 344,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 345,
   FQN="llvm::yaml::basic_collection_iterator::operator!=", NM="_ZNK4llvm4yaml25basic_collection_iteratorneERKNS0_25basic_collection_iteratorIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZNK4llvm4yaml25basic_collection_iteratorneERKNS0_25basic_collection_iteratorIT_T0_EE")
  //</editor-fold>
  public boolean $noteq(Object o) /*const*/ {
     basic_collection_iterator<BaseT, ValueT> /*&*/ Other = (basic_collection_iterator<BaseT, ValueT> /*&*/) o;
    return Native.$not((Native.$eq(Base, Other.Base)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::basic_collection_iterator::operator++">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", line = 348,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLParser.h", old_line = 349,
   FQN="llvm::yaml::basic_collection_iterator::operator++", NM="_ZN4llvm4yaml25basic_collection_iteratorppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN4llvm4yaml25basic_collection_iteratorppEv")
  //</editor-fold>
  public basic_collection_iterator<BaseT, ValueT> /*&*/ $preInc() {
    assert Native.$bool(Base) : "Attempted to advance iterator past end!";
    Base.increment();
    // Create an end iterator.
    if (Native.$not(Base.getCurrentEntry())) {
      Base = null;
    }
    return /*Deref*/this;
  }

/*private:*/
  private BaseT /*P*/ Base;
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  
  public basic_collection_iterator(basic_collection_iterator</*class*/ BaseT, /*class*/ ValueT> /*P*/ B) {
    this.Base = /*ParenListExpr*/B.Base;
  }

  @Override
  public basic_collection_iterator clone() {
    return new basic_collection_iterator(this);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Base=" + Base // NOI18N
              + super.toString(); // NOI18N
  }

}
