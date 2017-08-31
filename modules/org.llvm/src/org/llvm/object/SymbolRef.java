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


/// This is a value type class that represents a single symbol in the list of
/// symbols in the object file.
//<editor-fold defaultstate="collapsed" desc="llvm::object::SymbolRef">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 115,
 FQN="llvm::object::SymbolRef", NM="_ZN4llvm6object9SymbolRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm6object9SymbolRefE")
//</editor-fold>
public class SymbolRef extends /*public*/ BasicSymbolRef {
  /*friend  class SectionRef*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::object::SymbolRef::SymbolRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 119,
   FQN="llvm::object::SymbolRef::SymbolRef", NM="_ZN4llvm6object9SymbolRefC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm6object9SymbolRefC1Ev")
  //</editor-fold>
  public SymbolRef() {
    // : BasicSymbolRef() 
    super();
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::SymbolRef::Type">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 121,
   FQN="llvm::object::SymbolRef::Type", NM="_ZN4llvm6object9SymbolRef4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm6object9SymbolRef4TypeE")
  //</editor-fold>
  public enum Type implements Native.NativeUIntEnum {
    ST_Unknown(0), // Type not specified
    ST_Data(ST_Unknown.getValue() + 1),
    ST_Debug(ST_Data.getValue() + 1),
    ST_File(ST_Debug.getValue() + 1),
    ST_Function(ST_File.getValue() + 1),
    ST_Other(ST_Function.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Type valueOf(int val) {
      Type out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Type[] VALUES;
      private static final Type[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Type kind : Type.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Type[min < 0 ? (1-min) : 0];
        VALUES = new Type[max >= 0 ? (1+max) : 0];
        for (Type kind : Type.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private Type(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  
  // Inline function definitions.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::SymbolRef::SymbolRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 308,
   FQN="llvm::object::SymbolRef::SymbolRef", NM="_ZN4llvm6object9SymbolRefC1ENS0_11DataRefImplEPKNS0_10ObjectFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm6object9SymbolRefC1ENS0_11DataRefImplEPKNS0_10ObjectFileE")
  //</editor-fold>
  public /*inline*/ SymbolRef(DataRefImpl SymbolP, /*const*/ ObjectFile /*P*/ Owner) {
    // : BasicSymbolRef(SymbolP, Owner) 
    super(new DataRefImpl(SymbolP), Owner);
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::SymbolRef::SymbolRef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 131,
   FQN="llvm::object::SymbolRef::SymbolRef", NM="_ZN4llvm6object9SymbolRefC1ERKNS0_14BasicSymbolRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm6object9SymbolRefC1ERKNS0_14BasicSymbolRefE")
  //</editor-fold>
  public SymbolRef(final /*const*/ BasicSymbolRef /*&*/ B) {
    // : BasicSymbolRef(B) 
    super(B);
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::SymbolRef::getName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 311,
   FQN="llvm::object::SymbolRef::getName", NM="_ZNK4llvm6object9SymbolRef7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object9SymbolRef7getNameEv")
  //</editor-fold>
  public /*inline*/ Expected<StringRef> getName() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// Returns the symbol virtual address (i.e. address at which it will be
  /// mapped).
  //<editor-fold defaultstate="collapsed" desc="llvm::object::SymbolRef::getAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 315,
   FQN="llvm::object::SymbolRef::getAddress", NM="_ZNK4llvm6object9SymbolRef10getAddressEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object9SymbolRef10getAddressEv")
  //</editor-fold>
  public /*inline*/ Expected<Long/*uint64_t*/> getAddress() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return the value of the symbol depending on the object this can be an
  /// offset or a virtual address.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::SymbolRef::getValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 319,
   FQN="llvm::object::SymbolRef::getValue", NM="_ZNK4llvm6object9SymbolRef8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object9SymbolRef8getValueEv")
  //</editor-fold>
  public /*inline*/ long/*uint64_t*/ getValue() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// @brief Get the alignment of this symbol as the actual value (not log 2).
  //<editor-fold defaultstate="collapsed" desc="llvm::object::SymbolRef::getAlignment">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 323,
   FQN="llvm::object::SymbolRef::getAlignment", NM="_ZNK4llvm6object9SymbolRef12getAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object9SymbolRef12getAlignmentEv")
  //</editor-fold>
  public /*inline*/ /*uint32_t*/int getAlignment() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::SymbolRef::getCommonSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 327,
   FQN="llvm::object::SymbolRef::getCommonSize", NM="_ZNK4llvm6object9SymbolRef13getCommonSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object9SymbolRef13getCommonSizeEv")
  //</editor-fold>
  public /*inline*/ long/*uint64_t*/ getCommonSize() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::object::SymbolRef::getType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 335,
   FQN="llvm::object::SymbolRef::getType", NM="_ZNK4llvm6object9SymbolRef7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object9SymbolRef7getTypeEv")
  //</editor-fold>
  public /*inline*/ Expected<SymbolRef.Type> getType() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// @brief Get section this symbol is defined in reference to. Result is
  /// end_sections() if it is undefined or is an absolute symbol.
  //<editor-fold defaultstate="collapsed" desc="llvm::object::SymbolRef::getSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 331,
   FQN="llvm::object::SymbolRef::getSection", NM="_ZNK4llvm6object9SymbolRef10getSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object9SymbolRef10getSectionEv")
  //</editor-fold>
  public /*inline*/ Expected<content_iterator<SectionRef> > getSection() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::object::SymbolRef::getObject">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/ObjectFile.h", line = 339,
   FQN="llvm::object::SymbolRef::getObject", NM="_ZNK4llvm6object9SymbolRef9getObjectEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm6object9SymbolRef9getObjectEv")
  //</editor-fold>
  public /*inline*/ /*const*/ ObjectFile /*P*/ getObject() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
