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


/// This is a value type class that represents a single symbol in the list of
/// symbols in the object file.
//<editor-fold defaultstate="collapsed" desc="llvm::object::BasicSymbolRef">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 86,
 FQN="llvm::object::BasicSymbolRef", NM="_ZN4llvm6object14BasicSymbolRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm6object14BasicSymbolRefE")
//</editor-fold>
public class BasicSymbolRef implements Native.NativeComparable<BasicSymbolRef> {
  private DataRefImpl SymbolPimpl;
  private /*const*/ SymbolicFile /*P*/ OwningObject;
/*public:*/
  // FIXME: should we add a SF_Text?
  //<editor-fold defaultstate="collapsed" desc="llvm::object::BasicSymbolRef::Flags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 92,
   FQN="llvm::object::BasicSymbolRef::Flags", NM="_ZN4llvm6object14BasicSymbolRef5FlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm6object14BasicSymbolRef5FlagsE")
  //</editor-fold>
  public static final class/*enum*/ Flags/* : unsigned int*/ {
    public static final /*uint*/int SF_None = 0;
    public static final /*uint*/int SF_Undefined = 1/*U*/ << 0; // Symbol is defined in another object file
    public static final /*uint*/int SF_Global = 1/*U*/ << 1; // Global symbol
    public static final /*uint*/int SF_Weak = 1/*U*/ << 2; // Weak symbol
    public static final /*uint*/int SF_Absolute = 1/*U*/ << 3; // Absolute symbol
    public static final /*uint*/int SF_Common = 1/*U*/ << 4; // Symbol has common linkage
    public static final /*uint*/int SF_Indirect = 1/*U*/ << 5; // Symbol is an alias to another symbol
    public static final /*uint*/int SF_Exported = 1/*U*/ << 6; // Symbol is visible to other DSOs
    public static final /*uint*/int SF_FormatSpecific = 1/*U*/ << 7; // Specific to the object file format
    // (e.g. section symbols)
    public static final /*uint*/int SF_Thumb = 1/*U*/ << 8; // Thumb symbol in a 32-bit ARM binary
    public static final /*uint*/int SF_Hidden = 1/*U*/ << 9; // Symbol has hidden visibility
    public static final /*uint*/int SF_Const = 1/*U*/ << 10; // Symbol value is constant
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::BasicSymbolRef::BasicSymbolRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 108,
   FQN="llvm::object::BasicSymbolRef::BasicSymbolRef", NM="_ZN4llvm6object14BasicSymbolRefC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm6object14BasicSymbolRefC1Ev")
  //</editor-fold>
  public BasicSymbolRef() {
    // : SymbolPimpl(), OwningObject(null) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::BasicSymbolRef::BasicSymbolRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 173,
   FQN="llvm::object::BasicSymbolRef::BasicSymbolRef", NM="_ZN4llvm6object14BasicSymbolRefC1ENS0_11DataRefImplEPKNS0_12SymbolicFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm6object14BasicSymbolRefC1ENS0_11DataRefImplEPKNS0_12SymbolicFileE")
  //</editor-fold>
  public /*inline*/ BasicSymbolRef(DataRefImpl SymbolP, 
      /*const*/ SymbolicFile /*P*/ Owner) {
    // : SymbolPimpl(SymbolP), OwningObject(Owner) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::BasicSymbolRef::operator==">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 177,
   FQN="llvm::object::BasicSymbolRef::operator==", NM="_ZNK4llvm6object14BasicSymbolRefeqERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object14BasicSymbolRefeqERKS1_")
  //</editor-fold>
  public /*inline*/ boolean $eq(final /*const*/ BasicSymbolRef /*&*/ Other) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::BasicSymbolRef::operator<">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 181,
   FQN="llvm::object::BasicSymbolRef::operator<", NM="_ZNK4llvm6object14BasicSymbolRefltERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object14BasicSymbolRefltERKS1_")
  //</editor-fold>
  public /*inline*/ boolean $less(final /*const*/ BasicSymbolRef /*&*/ Other) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::BasicSymbolRef::moveNext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 185,
   FQN="llvm::object::BasicSymbolRef::moveNext", NM="_ZN4llvm6object14BasicSymbolRef8moveNextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm6object14BasicSymbolRef8moveNextEv")
  //</editor-fold>
  public /*inline*/ void moveNext() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::BasicSymbolRef::printName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 189,
   FQN="llvm::object::BasicSymbolRef::printName", NM="_ZNK4llvm6object14BasicSymbolRef9printNameERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object14BasicSymbolRef9printNameERNS_11raw_ostreamE")
  //</editor-fold>
  public /*inline*/ std.error_code printName(final raw_ostream /*&*/ OS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get symbol flags (bitwise OR of SymbolRef::Flags)
  //<editor-fold defaultstate="collapsed" desc="llvm::object::BasicSymbolRef::getFlags">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 193,
   FQN="llvm::object::BasicSymbolRef::getFlags", NM="_ZNK4llvm6object14BasicSymbolRef8getFlagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object14BasicSymbolRef8getFlagsEv")
  //</editor-fold>
  public /*inline*/ /*uint32_t*/int getFlags() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::BasicSymbolRef::getRawDataRefImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 197,
   FQN="llvm::object::BasicSymbolRef::getRawDataRefImpl", NM="_ZNK4llvm6object14BasicSymbolRef17getRawDataRefImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object14BasicSymbolRef17getRawDataRefImplEv")
  //</editor-fold>
  public /*inline*/ DataRefImpl getRawDataRefImpl() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::BasicSymbolRef::getObject">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 201,
   FQN="llvm::object::BasicSymbolRef::getObject", NM="_ZNK4llvm6object14BasicSymbolRef9getObjectEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object14BasicSymbolRef9getObjectEv")
  //</editor-fold>
  public /*inline*/ /*const*/ SymbolicFile /*P*/ getObject() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::BasicSymbolRef::BasicSymbolRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 86,
   FQN="llvm::object::BasicSymbolRef::BasicSymbolRef", NM="_ZN4llvm6object14BasicSymbolRefC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm6object14BasicSymbolRefC1ERKS1_")
  //</editor-fold>
  public /*inline*/ BasicSymbolRef(final /*const*/ BasicSymbolRef /*&*/ $Prm0) {
    // : SymbolPimpl(.SymbolPimpl), OwningObject(.OwningObject) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::BasicSymbolRef::BasicSymbolRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 86,
   FQN="llvm::object::BasicSymbolRef::BasicSymbolRef", NM="_ZN4llvm6object14BasicSymbolRefC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm6object14BasicSymbolRefC1EOS1_")
  //</editor-fold>
  public /*inline*/ BasicSymbolRef(JD$Move _dparam, final BasicSymbolRef /*&&*/$Prm0) {
    // : SymbolPimpl(static_cast<BasicSymbolRef &&>().SymbolPimpl), OwningObject(static_cast<BasicSymbolRef &&>().OwningObject) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "SymbolPimpl=" + SymbolPimpl // NOI18N
              + ", OwningObject=" + OwningObject; // NOI18N
  }
}
