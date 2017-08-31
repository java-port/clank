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

package org.clang.codegen.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.codegen.impl.*;


/// \brief A Helper struct that stores information about a class in a class
/// hierarchy.  The information stored in these structs struct is used during
/// the generation of ClassHierarchyDescriptors and BaseClassDescriptors.
// During RTTI creation, MSRTTIClasses are stored in a contiguous array with
// implicit depth first pre-order tree connectivity.  getFirstChild and
// getNextSibling allow us to walk the tree efficiently.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSRTTIClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3327,
 FQN="(anonymous namespace)::MSRTTIClass", NM="_ZN12_GLOBAL__N_111MSRTTIClassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_111MSRTTIClassE")
//</editor-fold>
public class/*struct*/ MSRTTIClass {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSRTTIClass::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3328,
   FQN="(anonymous namespace)::MSRTTIClass::(anonymous)", NM="_ZN12_GLOBAL__N_111MSRTTIClassE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_111MSRTTIClassE_Unnamed_enum")
  //</editor-fold>
  public enum Unnamed_enum implements Native.NativeUIntEnum {
    IsPrivateOnPath(1 | 8),
    IsAmbiguous(2),
    IsPrivate(4),
    IsVirtual(16),
    HasHierarchyDescriptor(64);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Unnamed_enum valueOf(int val) {
      Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Unnamed_enum[] VALUES;
      private static final Unnamed_enum[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Unnamed_enum[min < 0 ? (1-min) : 0];
        VALUES = new Unnamed_enum[max >= 0 ? (1+max) : 0];
        for (Unnamed_enum kind : Unnamed_enum.values()) {
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
    private Unnamed_enum(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSRTTIClass::MSRTTIClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3335,
   FQN="(anonymous namespace)::MSRTTIClass::MSRTTIClass", NM="_ZN12_GLOBAL__N_111MSRTTIClassC1EPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_111MSRTTIClassC1EPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  public MSRTTIClass(/*const*/ CXXRecordDecl /*P*/ RD) {
    // : RD(RD) 
    //START JInit
    this.RD = RD;
    //END JInit
  }

  
  /// \brief Recursively initialize the base class array.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSRTTIClass::initialize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3349,
   FQN="(anonymous namespace)::MSRTTIClass::initialize", NM="_ZN12_GLOBAL__N_111MSRTTIClass10initializeEPKS0_PKN5clang16CXXBaseSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_111MSRTTIClass10initializeEPKS0_PKN5clang16CXXBaseSpecifierE")
  //</editor-fold>
  public /*uint32_t*/int initialize(/*const*/ MSRTTIClass /*P*/ Parent, 
            /*const*/ CXXBaseSpecifier /*P*/ Specifier) {
    Flags = Unnamed_enum.HasHierarchyDescriptor.getValue();
    if (!(Parent != null)) {
      VirtualRoot = null;
      OffsetInVBase = 0;
    } else {
      if (Specifier.getAccessSpecifier() != AccessSpecifier.AS_public) {
        Flags |= Unnamed_enum.IsPrivate.getValue() | Unnamed_enum.IsPrivateOnPath.getValue();
      }
      if (Specifier.isVirtual()) {
        Flags |= Unnamed_enum.IsVirtual.getValue();
        VirtualRoot = RD;
        OffsetInVBase = 0;
      } else {
        if (((Parent.Flags & Unnamed_enum.IsPrivateOnPath.getValue()) != 0)) {
          Flags |= Unnamed_enum.IsPrivateOnPath.getValue();
        }
        VirtualRoot = Parent.VirtualRoot;
        OffsetInVBase = $llong2uint($uint2llong(Parent.OffsetInVBase) + RD.getASTContext().
            getASTRecordLayout(Parent.RD).getBaseClassOffset(RD).getQuantity());
      }
    }
    NumBases = 0;
    type$ptr<MSRTTIClass> /*P*/ Child = getFirstChild();
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : RD.bases$Const()) {
      NumBases += Child.$star().initialize(this, /*AddrOf*/Base) + 1;
      Child = MSRTTIClass.getNextChild(Child);
    }
    return NumBases;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSRTTIClass::getFirstChild">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3339,
   FQN="(anonymous namespace)::MSRTTIClass::getFirstChild", NM="_ZN12_GLOBAL__N_111MSRTTIClass13getFirstChildEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_111MSRTTIClass13getFirstChildEv")
  //</editor-fold>
  public type$ptr<MSRTTIClass> /*P*/ getFirstChild() {
    return $this().$add(1);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSRTTIClass::getNextChild">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3340,
   FQN="(anonymous namespace)::MSRTTIClass::getNextChild", NM="_ZN12_GLOBAL__N_111MSRTTIClass12getNextChildEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_111MSRTTIClass12getNextChildEPS0_")
  //</editor-fold>
  public static type$ptr<MSRTTIClass> /*P*/ getNextChild(type$ptr<MSRTTIClass> /*P*/ Child) {
    return Child.$add(1 + Child.$star().NumBases);
  }

  
  public /*const*/ CXXRecordDecl /*P*/ RD;
  
  public /*const*/ CXXRecordDecl /*P*/ VirtualRoot;
  public /*uint32_t*/int Flags;
  public /*uint32_t*/int NumBases;
  public /*uint32_t*/int OffsetInVBase;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MSRTTIClass::MSRTTIClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3327,
   FQN="(anonymous namespace)::MSRTTIClass::MSRTTIClass", NM="_ZN12_GLOBAL__N_111MSRTTIClassC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_111MSRTTIClassC1ERKS0_")
  //</editor-fold>
  public /*inline*/ MSRTTIClass(final /*const*/ MSRTTIClass /*&*/ $Prm0) {
    // : RD(.RD), VirtualRoot(.VirtualRoot), Flags(.Flags), NumBases(.NumBases), OffsetInVBase(.OffsetInVBase) 
    //START JInit
    this.RD = $Prm0.RD;
    this.VirtualRoot = $Prm0.VirtualRoot;
    this.Flags = $Prm0.Flags;
    this.NumBases = $Prm0.NumBases;
    this.OffsetInVBase = $Prm0.OffsetInVBase;
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public MSRTTIClass() {
    this.Flags = 0;
    this.NumBases = 0;
    this.OffsetInVBase = 0;
    this.RD = null;
    this.VirtualRoot = null;
  }
  
  private type$ptr<MSRTTIClass> $this() {
    throw new UnsupportedOperationException("EmptyBody: implement $this()");
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "RD=" + "[CXXRecordDecl]" // NOI18N
              + ", VirtualRoot=" + "[CXXRecordDecl]" // NOI18N
              + ", Flags=" + Flags // NOI18N
              + ", NumBases=" + NumBases // NOI18N
              + ", OffsetInVBase=" + OffsetInVBase; // NOI18N
  }
}
