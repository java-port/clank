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

package org.llvm.bitcode.reader.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.ir.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderValueList">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 55,
 FQN="(anonymous namespace)::BitcodeReaderValueList", NM="_ZN12_GLOBAL__N_122BitcodeReaderValueListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_122BitcodeReaderValueListE")
//</editor-fold>
public class BitcodeReaderValueList implements Destructors.ClassWithDestructor {
  private std.vector<WeakVH> ValuePtrs;
  
  /// As we resolve forward-referenced constants, we add information about them
  /// to this vector.  This allows us to resolve them in bulk instead of
  /// resolving each reference at a time.  See the code in
  /// ResolveConstantForwardRefs for more information about this.
  ///
  /// The key of this vector is the placeholder constant, the value is the slot
  /// number that holds the resolved value.
  /*typedef std::vector<std::pair<Constant *, unsigned int> > ResolveConstantsTy*/
//  public final class ResolveConstantsTy extends std.vector<std.pairTypeUInt<Constant /*P*/ >>{ };
  private std.vector<std.pairTypeUInt<Constant /*P*/ >> ResolveConstants;
  private LLVMContext /*&*/ Context;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderValueList::BitcodeReaderValueList">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 69,
   FQN="(anonymous namespace)::BitcodeReaderValueList::BitcodeReaderValueList", NM="_ZN12_GLOBAL__N_122BitcodeReaderValueListC1ERN4llvm11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_122BitcodeReaderValueListC1ERN4llvm11LLVMContextE")
  //</editor-fold>
  public BitcodeReaderValueList(LLVMContext /*&*/ C) {
    // : ValuePtrs(), ResolveConstants(), Context(C) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderValueList::~BitcodeReaderValueList">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 70,
   FQN="(anonymous namespace)::BitcodeReaderValueList::~BitcodeReaderValueList", NM="_ZN12_GLOBAL__N_122BitcodeReaderValueListD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_122BitcodeReaderValueListD0Ev")
  //</editor-fold>
  public void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // vector compatibility methods
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderValueList::size">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 75,
   FQN="(anonymous namespace)::BitcodeReaderValueList::size", NM="_ZNK12_GLOBAL__N_122BitcodeReaderValueList4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZNK12_GLOBAL__N_122BitcodeReaderValueList4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderValueList::resize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 76,
   FQN="(anonymous namespace)::BitcodeReaderValueList::resize", NM="_ZN12_GLOBAL__N_122BitcodeReaderValueList6resizeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_122BitcodeReaderValueList6resizeEj")
  //</editor-fold>
  public void resize(/*uint*/int N) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderValueList::push_back">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 77,
   FQN="(anonymous namespace)::BitcodeReaderValueList::push_back", NM="_ZN12_GLOBAL__N_122BitcodeReaderValueList9push_backEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_122BitcodeReaderValueList9push_backEPN4llvm5ValueE")
  //</editor-fold>
  public void push_back(Value /*P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderValueList::clear">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 79,
   FQN="(anonymous namespace)::BitcodeReaderValueList::clear", NM="_ZN12_GLOBAL__N_122BitcodeReaderValueList5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_122BitcodeReaderValueList5clearEv")
  //</editor-fold>
  public void clear() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderValueList::operator[]">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 84,
   FQN="(anonymous namespace)::BitcodeReaderValueList::operator[]", NM="_ZNK12_GLOBAL__N_122BitcodeReaderValueListixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZNK12_GLOBAL__N_122BitcodeReaderValueListixEj")
  //</editor-fold>
  public Value /*P*/ $at(/*uint*/int i) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderValueList::back">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 89,
   FQN="(anonymous namespace)::BitcodeReaderValueList::back", NM="_ZNK12_GLOBAL__N_122BitcodeReaderValueList4backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZNK12_GLOBAL__N_122BitcodeReaderValueList4backEv")
  //</editor-fold>
  public Value /*P*/ back() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderValueList::pop_back">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 90,
   FQN="(anonymous namespace)::BitcodeReaderValueList::pop_back", NM="_ZN12_GLOBAL__N_122BitcodeReaderValueList8pop_backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_122BitcodeReaderValueList8pop_backEv")
  //</editor-fold>
  public void pop_back() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderValueList::empty">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 91,
   FQN="(anonymous namespace)::BitcodeReaderValueList::empty", NM="_ZNK12_GLOBAL__N_122BitcodeReaderValueList5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZNK12_GLOBAL__N_122BitcodeReaderValueList5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderValueList::shrinkTo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 92,
   FQN="(anonymous namespace)::BitcodeReaderValueList::shrinkTo", NM="_ZN12_GLOBAL__N_122BitcodeReaderValueList8shrinkToEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_122BitcodeReaderValueList8shrinkToEj")
  //</editor-fold>
  public void shrinkTo(/*uint*/int N) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderValueList::getConstantFwdRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 969,
   FQN="(anonymous namespace)::BitcodeReaderValueList::getConstantFwdRef", NM="_ZN12_GLOBAL__N_122BitcodeReaderValueList17getConstantFwdRefEjPN4llvm4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_122BitcodeReaderValueList17getConstantFwdRefEjPN4llvm4TypeE")
  //</editor-fold>
  public Constant /*P*/ getConstantFwdRef(/*uint*/int Idx, 
                   Type /*P*/ Ty) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderValueList::getValueFwdRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 986,
   FQN="(anonymous namespace)::BitcodeReaderValueList::getValueFwdRef", NM="_ZN12_GLOBAL__N_122BitcodeReaderValueList14getValueFwdRefEjPN4llvm4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_122BitcodeReaderValueList14getValueFwdRefEjPN4llvm4TypeE")
  //</editor-fold>
  public Value /*P*/ getValueFwdRef(/*uint*/int Idx, Type /*P*/ Ty) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // end namespace llvm
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderValueList::assignValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 941,
   FQN="(anonymous namespace)::BitcodeReaderValueList::assignValue", NM="_ZN12_GLOBAL__N_122BitcodeReaderValueList11assignValueEPN4llvm5ValueEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_122BitcodeReaderValueList11assignValueEPN4llvm5ValueEj")
  //</editor-fold>
  public void assignValue(Value /*P*/ V, /*uint*/int Idx) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Once all constants are read, this method bulk resolves any forward
  /// references.
  
  /// Once all constants are read, this method bulk resolves any forward
  /// references.  The idea behind this is that we sometimes get constants (such
  /// as large arrays) which reference *many* forward ref constants.  Replacing
  /// each of these causes a lot of thrashing when building/reuniquing the
  /// constant.  Instead of doing this, we look at all the uses and rewrite all
  /// the place holders at once for any constant that uses a placeholder.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitcodeReaderValueList::resolveConstantForwardRefs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 1016,
   FQN="(anonymous namespace)::BitcodeReaderValueList::resolveConstantForwardRefs", NM="_ZN12_GLOBAL__N_122BitcodeReaderValueList26resolveConstantForwardRefsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_122BitcodeReaderValueList26resolveConstantForwardRefsEv")
  //</editor-fold>
  public void resolveConstantForwardRefs() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "ValuePtrs=" + ValuePtrs // NOI18N
              + ", ResolveConstants=" + ResolveConstants // NOI18N
              + ", Context=" + Context; // NOI18N
  }
}
