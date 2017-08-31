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

package org.llvm.debuginfo;

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

//<editor-fold defaultstate="collapsed" desc="llvm::DIContext">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DIContext.h", line = 130,
 FQN="llvm::DIContext", NM="_ZN4llvm9DIContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DIContextE")
//</editor-fold>
public abstract class DIContext implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DIContext::DIContextKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DIContext.h", line = 132,
   FQN="llvm::DIContext::DIContextKind", NM="_ZN4llvm9DIContext13DIContextKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DIContext13DIContextKindE")
  //</editor-fold>
  public enum DIContextKind implements Native.NativeUIntEnum {
    CK_DWARF(0),
    CK_PDB(CK_DWARF.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static DIContextKind valueOf(int val) {
      DIContextKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final DIContextKind[] VALUES;
      private static final DIContextKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (DIContextKind kind : DIContextKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new DIContextKind[min < 0 ? (1-min) : 0];
        VALUES = new DIContextKind[max >= 0 ? (1+max) : 0];
        for (DIContextKind kind : DIContextKind.values()) {
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
    private DIContextKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="llvm::DIContext::getKind">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DIContext.h", line = 136,
   FQN="llvm::DIContext::getKind", NM="_ZNK4llvm9DIContext7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm9DIContext7getKindEv")
  //</editor-fold>
  public DIContextKind getKind() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DIContext::DIContext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DIContext.h", line = 138,
   FQN="llvm::DIContext::DIContext", NM="_ZN4llvm9DIContextC1ENS0_13DIContextKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DIContextC1ENS0_13DIContextKindE")
  //</editor-fold>
  public DIContext(DIContextKind K) {
    // : Kind(K) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIContext::~DIContext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DIContext.h", line = 139,
   FQN="llvm::DIContext::~DIContext", NM="_ZN4llvm9DIContextD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DIContextD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DIContext::dump">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DIContext.h", line = 141,
   FQN="llvm::DIContext::dump", NM="_ZN4llvm9DIContext4dumpERNS_11raw_ostreamENS_10DIDumpTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DIContext4dumpERNS_11raw_ostreamENS_10DIDumpTypeEb")
  //</editor-fold>
  public abstract /*virtual*/ void dump(final raw_ostream /*&*/ OS)/* = 0*/;
  public abstract /*virtual*/ void dump(final raw_ostream /*&*/ OS, DIDumpType DumpType/*= DIDT_All*/)/* = 0*/;
  public abstract /*virtual*/ void dump(final raw_ostream /*&*/ OS, DIDumpType DumpType/*= DIDT_All*/, 
      boolean DumpEH/*= false*/)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DIContext::getLineInfoForAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DIContext.h", line = 144,
   FQN="llvm::DIContext::getLineInfoForAddress", NM="_ZN4llvm9DIContext21getLineInfoForAddressEyNS_19DILineInfoSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DIContext21getLineInfoForAddressEyNS_19DILineInfoSpecifierE")
  //</editor-fold>
  public abstract /*virtual*/ DILineInfo getLineInfoForAddress(long/*uint64_t*/ Address)/* = 0*/;
  public abstract /*virtual*/ DILineInfo getLineInfoForAddress(long/*uint64_t*/ Address, 
                       DILineInfoSpecifier Specifier/*= DILineInfoSpecifier()*/)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DIContext::getLineInfoForAddressRange">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DIContext.h", line = 146,
   FQN="llvm::DIContext::getLineInfoForAddressRange", NM="_ZN4llvm9DIContext26getLineInfoForAddressRangeEyyNS_19DILineInfoSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DIContext26getLineInfoForAddressRangeEyyNS_19DILineInfoSpecifierE")
  //</editor-fold>
  public abstract /*virtual*/ SmallVector<std.pairULongType<DILineInfo>> getLineInfoForAddressRange(long/*uint64_t*/ Address, 
                            long/*uint64_t*/ Size)/* = 0*/;
  public abstract /*virtual*/ SmallVector<std.pairULongType<DILineInfo>> getLineInfoForAddressRange(long/*uint64_t*/ Address, 
                            long/*uint64_t*/ Size, DILineInfoSpecifier Specifier/*= DILineInfoSpecifier()*/)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DIContext::getInliningInfoForAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DIContext.h", line = 148,
   FQN="llvm::DIContext::getInliningInfoForAddress", NM="_ZN4llvm9DIContext25getInliningInfoForAddressEyNS_19DILineInfoSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm9DIContext25getInliningInfoForAddressEyNS_19DILineInfoSpecifierE")
  //</editor-fold>
  public abstract /*virtual*/ DIInliningInfo getInliningInfoForAddress(long/*uint64_t*/ Address)/* = 0*/;
  public abstract /*virtual*/ DIInliningInfo getInliningInfoForAddress(long/*uint64_t*/ Address, 
                           DILineInfoSpecifier Specifier/*= DILineInfoSpecifier()*/)/* = 0*/;

/*private:*/
  private /*const*/ DIContextKind Kind;
  
  @Override public String toString() {
    return "" + "Kind=" + Kind; // NOI18N
  }
}
