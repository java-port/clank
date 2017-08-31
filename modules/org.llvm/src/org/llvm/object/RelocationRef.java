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

package org.llvm.object;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.Error;


/// This is a value type class that represents a single relocation in the list
/// of relocations in the object file.
//<editor-fold defaultstate="collapsed" desc="llvm::object::RelocationRef">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 40,
 FQN="llvm::object::RelocationRef", NM="_ZN4llvm6object13RelocationRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm6object13RelocationRefE")
//</editor-fold>
public class RelocationRef implements Native.NativeComparable<RelocationRef> {
  private DataRefImpl RelocationPimpl;
  private /*const*/ ObjectFile /*P*/ OwningObject;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::object::RelocationRef::RelocationRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 45,
   FQN="llvm::object::RelocationRef::RelocationRef", NM="_ZN4llvm6object13RelocationRefC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm6object13RelocationRefC1Ev")
  //</editor-fold>
  public RelocationRef() {
    // : RelocationPimpl(), OwningObject(null) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  /// RelocationRef
  //<editor-fold defaultstate="collapsed" desc="llvm::object::RelocationRef::RelocationRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 432,
   FQN="llvm::object::RelocationRef::RelocationRef", NM="_ZN4llvm6object13RelocationRefC1ENS0_11DataRefImplEPKNS0_10ObjectFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm6object13RelocationRefC1ENS0_11DataRefImplEPKNS0_10ObjectFileE")
  //</editor-fold>
  public /*inline*/ RelocationRef(DataRefImpl RelocationP, 
      /*const*/ ObjectFile /*P*/ Owner) {
    // : RelocationPimpl(RelocationP), OwningObject(Owner) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::RelocationRef::operator==">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 437,
   FQN="llvm::object::RelocationRef::operator==", NM="_ZNK4llvm6object13RelocationRefeqERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object13RelocationRefeqERKS1_")
  //</editor-fold>
  public /*inline*/ boolean $eq(final /*const*/ RelocationRef /*&*/ Other) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::RelocationRef::moveNext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 441,
   FQN="llvm::object::RelocationRef::moveNext", NM="_ZN4llvm6object13RelocationRef8moveNextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm6object13RelocationRef8moveNextEv")
  //</editor-fold>
  public /*inline*/ void moveNext() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::RelocationRef::getOffset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 445,
   FQN="llvm::object::RelocationRef::getOffset", NM="_ZNK4llvm6object13RelocationRef9getOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object13RelocationRef9getOffsetEv")
  //</editor-fold>
  public /*inline*/ long/*uint64_t*/ getOffset() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::RelocationRef::getSymbol">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 449,
   FQN="llvm::object::RelocationRef::getSymbol", NM="_ZNK4llvm6object13RelocationRef9getSymbolEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object13RelocationRef9getSymbolEv")
  //</editor-fold>
  public /*inline*/ symbol_iterator getSymbol() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::RelocationRef::getType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 453,
   FQN="llvm::object::RelocationRef::getType", NM="_ZNK4llvm6object13RelocationRef7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object13RelocationRef7getTypeEv")
  //</editor-fold>
  public /*inline*/ long/*uint64_t*/ getType() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// @brief Get a string that represents the type of this relocation.
  ///
  /// This is for display purposes only.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::RelocationRef::getTypeName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 457,
   FQN="llvm::object::RelocationRef::getTypeName", NM="_ZNK4llvm6object13RelocationRef11getTypeNameERNS_15SmallVectorImplIcEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object13RelocationRef11getTypeNameERNS_15SmallVectorImplIcEE")
  //</editor-fold>
  public /*inline*/ void getTypeName(final SmallString/*&*/ Result) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::RelocationRef::getRawDataRefImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 461,
   FQN="llvm::object::RelocationRef::getRawDataRefImpl", NM="_ZNK4llvm6object13RelocationRef17getRawDataRefImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object13RelocationRef17getRawDataRefImplEv")
  //</editor-fold>
  public /*inline*/ DataRefImpl getRawDataRefImpl() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::RelocationRef::getObject">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 465,
   FQN="llvm::object::RelocationRef::getObject", NM="_ZNK4llvm6object13RelocationRef9getObjectEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object13RelocationRef9getObjectEv")
  //</editor-fold>
  public /*inline*/ /*const*/ ObjectFile /*P*/ getObject() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::RelocationRef::RelocationRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 40,
   FQN="llvm::object::RelocationRef::RelocationRef", NM="_ZN4llvm6object13RelocationRefC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm6object13RelocationRefC1EOS1_")
  //</editor-fold>
  public /*inline*/ RelocationRef(JD$Move _dparam, final RelocationRef /*&&*/$Prm0) {
    // : RelocationPimpl(static_cast<RelocationRef &&>().RelocationPimpl), OwningObject(static_cast<RelocationRef &&>().OwningObject) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "RelocationPimpl=" + RelocationPimpl // NOI18N
              + ", OwningObject=" + OwningObject; // NOI18N
  }
}
