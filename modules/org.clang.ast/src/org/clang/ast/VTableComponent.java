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

package org.clang.ast;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;

/// \brief Represents a single component in a vtable.
//<editor-fold defaultstate="collapsed" desc="clang::VTableComponent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 31,
 FQN="clang::VTableComponent", NM="_ZN5clang15VTableComponentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang15VTableComponentE")
//</editor-fold>
public class VTableComponent {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 33,
   FQN="clang::VTableComponent::Kind", NM="_ZN5clang15VTableComponent4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang15VTableComponent4KindE")
  //</editor-fold>
  public enum Kind implements Native.ComparableLower {
    CK_VCallOffset(0),
    CK_VBaseOffset(CK_VCallOffset.getValue() + 1),
    CK_OffsetToTop(CK_VBaseOffset.getValue() + 1),
    CK_RTTI(CK_OffsetToTop.getValue() + 1),
    CK_FunctionPointer(CK_RTTI.getValue() + 1),
    
    /// \brief A pointer to the complete destructor.
    CK_CompleteDtorPointer(CK_FunctionPointer.getValue() + 1),
    
    /// \brief A pointer to the deleting destructor.
    CK_DeletingDtorPointer(CK_CompleteDtorPointer.getValue() + 1),
    
    /// \brief An entry that is never used.
    ///
    /// In some cases, a vtable function pointer will end up never being
    /// called. Such vtable function pointers are represented as a
    /// CK_UnusedFunctionPointer.
    CK_UnusedFunctionPointer(CK_DeletingDtorPointer.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Kind valueOf(int val) {
      Kind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Kind[] VALUES;
      private static final Kind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Kind kind : Kind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Kind[min < 0 ? (1-min) : 0];
        VALUES = new Kind[max >= 0 ? (1+max) : 0];
        for (Kind kind : Kind.values()) {
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
    private Kind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Kind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Kind)obj).value);}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::VTableComponent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 54,
   FQN="clang::VTableComponent::VTableComponent", NM="_ZN5clang15VTableComponentC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang15VTableComponentC1Ev")
  //</editor-fold>
  public VTableComponent()/* = default*/ {
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::MakeVCallOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 56,
   FQN="clang::VTableComponent::MakeVCallOffset", NM="_ZN5clang15VTableComponent15MakeVCallOffsetENS_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang15VTableComponent15MakeVCallOffsetENS_9CharUnitsE")
  //</editor-fold>
  public static VTableComponent MakeVCallOffset(CharUnits Offset) {
    return new VTableComponent(Kind.CK_VCallOffset, new CharUnits(Offset));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::MakeVBaseOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 60,
   FQN="clang::VTableComponent::MakeVBaseOffset", NM="_ZN5clang15VTableComponent15MakeVBaseOffsetENS_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang15VTableComponent15MakeVBaseOffsetENS_9CharUnitsE")
  //</editor-fold>
  public static VTableComponent MakeVBaseOffset(CharUnits Offset) {
    return new VTableComponent(Kind.CK_VBaseOffset, new CharUnits(Offset));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::MakeOffsetToTop">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 64,
   FQN="clang::VTableComponent::MakeOffsetToTop", NM="_ZN5clang15VTableComponent15MakeOffsetToTopENS_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang15VTableComponent15MakeOffsetToTopENS_9CharUnitsE")
  //</editor-fold>
  public static VTableComponent MakeOffsetToTop(CharUnits Offset) {
    return new VTableComponent(Kind.CK_OffsetToTop, new CharUnits(Offset));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::MakeRTTI">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 68,
   FQN="clang::VTableComponent::MakeRTTI", NM="_ZN5clang15VTableComponent8MakeRTTIEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang15VTableComponent8MakeRTTIEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public static VTableComponent MakeRTTI(/*const*/ CXXRecordDecl /*P*/ RD) {
    return new VTableComponent(Kind.CK_RTTI, RD);
    //        reinterpret_cast_Object/*uintptr_t*/(RD));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::MakeFunction">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 72,
   FQN="clang::VTableComponent::MakeFunction", NM="_ZN5clang15VTableComponent12MakeFunctionEPKNS_13CXXMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang15VTableComponent12MakeFunctionEPKNS_13CXXMethodDeclE")
  //</editor-fold>
  public static VTableComponent MakeFunction(/*const*/ CXXMethodDecl /*P*/ MD) {
    assert (!isa_CXXDestructorDecl(MD)) : "Don't use MakeFunction with destructors!";
    
    return new VTableComponent(Kind.CK_FunctionPointer, MD);
    //    reinterpret_cast_Object/*uintptr_t*/(MD));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::MakeCompleteDtor">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 80,
   FQN="clang::VTableComponent::MakeCompleteDtor", NM="_ZN5clang15VTableComponent16MakeCompleteDtorEPKNS_17CXXDestructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang15VTableComponent16MakeCompleteDtorEPKNS_17CXXDestructorDeclE")
  //</editor-fold>
  public static VTableComponent MakeCompleteDtor(/*const*/ CXXDestructorDecl /*P*/ DD) {
    return new VTableComponent(Kind.CK_CompleteDtorPointer, DD);
    //    reinterpret_cast_Object/*uintptr_t*/(DD));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::MakeDeletingDtor">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 85,
   FQN="clang::VTableComponent::MakeDeletingDtor", NM="_ZN5clang15VTableComponent16MakeDeletingDtorEPKNS_17CXXDestructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang15VTableComponent16MakeDeletingDtorEPKNS_17CXXDestructorDeclE")
  //</editor-fold>
  public static VTableComponent MakeDeletingDtor(/*const*/ CXXDestructorDecl /*P*/ DD) {
    return new VTableComponent(Kind.CK_DeletingDtorPointer, DD);
    //    reinterpret_cast_Object/*uintptr_t*/(DD));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::MakeUnusedFunction">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 90,
   FQN="clang::VTableComponent::MakeUnusedFunction", NM="_ZN5clang15VTableComponent18MakeUnusedFunctionEPKNS_13CXXMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang15VTableComponent18MakeUnusedFunctionEPKNS_13CXXMethodDeclE")
  //</editor-fold>
  public static VTableComponent MakeUnusedFunction(/*const*/ CXXMethodDecl /*P*/ MD) {
    assert (!isa_CXXDestructorDecl(MD)) : "Don't use MakeUnusedFunction with destructors!";
    return new VTableComponent(Kind.CK_UnusedFunctionPointer, MD);
    //    reinterpret_cast_Object/*uintptr_t*/(MD));
  }

  
//  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::getFromOpaqueInteger">
//  @Converted(kind = Converted.Kind.DELETED, //investigate clients
//   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 97,
//   FQN="clang::VTableComponent::getFromOpaqueInteger", NM="_ZN5clang15VTableComponent20getFromOpaqueIntegerEy",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang15VTableComponent20getFromOpaqueIntegerEy")
//  //</editor-fold>
//  public static VTableComponent getFromOpaqueInteger(long/*uint64_t*/ I) {
//    return new VTableComponent(I);
//  }

  
  /// \brief Get the kind of this vtable component.
  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::getKind">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 102,
   FQN="clang::VTableComponent::getKind", NM="_ZNK5clang15VTableComponent7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZNK5clang15VTableComponent7getKindEv")
  //</editor-fold>
  public Kind getKind() /*const*/ {
    return Kind.valueOf(Value$Kind);//(Value & 0x7));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::getVCallOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 106,
   FQN="clang::VTableComponent::getVCallOffset", NM="_ZNK5clang15VTableComponent14getVCallOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZNK5clang15VTableComponent14getVCallOffsetEv")
  //</editor-fold>
  public CharUnits getVCallOffset() /*const*/ {
    assert (getKind() == Kind.CK_VCallOffset) : "Invalid component kind!";
    
    return getOffset();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::getVBaseOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 112,
   FQN="clang::VTableComponent::getVBaseOffset", NM="_ZNK5clang15VTableComponent14getVBaseOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZNK5clang15VTableComponent14getVBaseOffsetEv")
  //</editor-fold>
  public CharUnits getVBaseOffset() /*const*/ {
    assert (getKind() == Kind.CK_VBaseOffset) : "Invalid component kind!";
    
    return getOffset();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::getOffsetToTop">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 118,
   FQN="clang::VTableComponent::getOffsetToTop", NM="_ZNK5clang15VTableComponent14getOffsetToTopEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZNK5clang15VTableComponent14getOffsetToTopEv")
  //</editor-fold>
  public CharUnits getOffsetToTop() /*const*/ {
    assert (getKind() == Kind.CK_OffsetToTop) : "Invalid component kind!";
    
    return getOffset();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::getRTTIDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 124,
   FQN="clang::VTableComponent::getRTTIDecl", NM="_ZNK5clang15VTableComponent11getRTTIDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZNK5clang15VTableComponent11getRTTIDeclEv")
  //</editor-fold>
  public /*const*/ CXXRecordDecl /*P*/ getRTTIDecl() /*const*/ {
    assert (isRTTIKind()) : "Invalid component kind!";
    return reinterpret_cast(CXXRecordDecl /*P*/ .class, getPointer());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::getFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 129,
   FQN="clang::VTableComponent::getFunctionDecl", NM="_ZNK5clang15VTableComponent15getFunctionDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZNK5clang15VTableComponent15getFunctionDeclEv")
  //</editor-fold>
  public /*const*/ CXXMethodDecl /*P*/ getFunctionDecl() /*const*/ {
    assert (isFunctionPointerKind()) : "Invalid component kind!";
    if (isDestructorKind()) {
      return getDestructorDecl();
    }
    return reinterpret_cast(CXXMethodDecl /*P*/ .class, getPointer());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::getDestructorDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 136,
   FQN="clang::VTableComponent::getDestructorDecl", NM="_ZNK5clang15VTableComponent17getDestructorDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZNK5clang15VTableComponent17getDestructorDeclEv")
  //</editor-fold>
  public /*const*/ CXXDestructorDecl /*P*/ getDestructorDecl() /*const*/ {
    assert (isDestructorKind()) : "Invalid component kind!";
    return reinterpret_cast(CXXDestructorDecl /*P*/ .class, getPointer());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::getUnusedFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 141,
   FQN="clang::VTableComponent::getUnusedFunctionDecl", NM="_ZNK5clang15VTableComponent21getUnusedFunctionDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZNK5clang15VTableComponent21getUnusedFunctionDeclEv")
  //</editor-fold>
  public /*const*/ CXXMethodDecl /*P*/ getUnusedFunctionDecl() /*const*/ {
    assert (getKind() == Kind.CK_UnusedFunctionPointer) : "Invalid component kind!";
    return reinterpret_cast(CXXMethodDecl /*P*/ .class, getPointer());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::isDestructorKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 146,
   FQN="clang::VTableComponent::isDestructorKind", NM="_ZNK5clang15VTableComponent16isDestructorKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZNK5clang15VTableComponent16isDestructorKindEv")
  //</editor-fold>
  public boolean isDestructorKind() /*const*/ {
    return isDestructorKind(getKind());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::isUsedFunctionPointerKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 148,
   FQN="clang::VTableComponent::isUsedFunctionPointerKind", NM="_ZNK5clang15VTableComponent25isUsedFunctionPointerKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZNK5clang15VTableComponent25isUsedFunctionPointerKindEv")
  //</editor-fold>
  public boolean isUsedFunctionPointerKind() /*const*/ {
    return isUsedFunctionPointerKind(getKind());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::isFunctionPointerKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 152,
   FQN="clang::VTableComponent::isFunctionPointerKind", NM="_ZNK5clang15VTableComponent21isFunctionPointerKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZNK5clang15VTableComponent21isFunctionPointerKindEv")
  //</editor-fold>
  public boolean isFunctionPointerKind() /*const*/ {
    return isFunctionPointerKind(getKind());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::isRTTIKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 156,
   FQN="clang::VTableComponent::isRTTIKind", NM="_ZNK5clang15VTableComponent10isRTTIKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZNK5clang15VTableComponent10isRTTIKindEv")
  //</editor-fold>
  public boolean isRTTIKind() /*const*/ {
    return isRTTIKind(getKind());
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::isFunctionPointerKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 159,
   FQN="clang::VTableComponent::isFunctionPointerKind", NM="_ZN5clang15VTableComponent21isFunctionPointerKindENS0_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang15VTableComponent21isFunctionPointerKindENS0_4KindE")
  //</editor-fold>
  private static boolean isFunctionPointerKind(Kind ComponentKind) {
    return isUsedFunctionPointerKind(ComponentKind)
       || ComponentKind == Kind.CK_UnusedFunctionPointer;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::isUsedFunctionPointerKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 163,
   FQN="clang::VTableComponent::isUsedFunctionPointerKind", NM="_ZN5clang15VTableComponent25isUsedFunctionPointerKindENS0_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang15VTableComponent25isUsedFunctionPointerKindENS0_4KindE")
  //</editor-fold>
  private static boolean isUsedFunctionPointerKind(Kind ComponentKind) {
    return ComponentKind == Kind.CK_FunctionPointer
       || isDestructorKind(ComponentKind);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::isDestructorKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 167,
   FQN="clang::VTableComponent::isDestructorKind", NM="_ZN5clang15VTableComponent16isDestructorKindENS0_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang15VTableComponent16isDestructorKindENS0_4KindE")
  //</editor-fold>
  private static boolean isDestructorKind(Kind ComponentKind) {
    return ComponentKind == Kind.CK_CompleteDtorPointer
       || ComponentKind == Kind.CK_DeletingDtorPointer;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::isRTTIKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 171,
   FQN="clang::VTableComponent::isRTTIKind", NM="_ZN5clang15VTableComponent10isRTTIKindENS0_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang15VTableComponent10isRTTIKindENS0_4KindE")
  //</editor-fold>
  private static boolean isRTTIKind(Kind ComponentKind) {
    return ComponentKind == Kind.CK_RTTI;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::VTableComponent">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 175,
   FQN="clang::VTableComponent::VTableComponent", NM="_ZN5clang15VTableComponentC1ENS0_4KindENS_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang15VTableComponentC1ENS0_4KindENS_9CharUnitsE")
  //</editor-fold>
  private VTableComponent(Kind ComponentKind, CharUnits Offset) {
    assert ((ComponentKind == Kind.CK_VCallOffset || ComponentKind == Kind.CK_VBaseOffset || ComponentKind == Kind.CK_OffsetToTop)) : "Invalid component kind!";
    //assert (Offset.getQuantity() < (1L/*LL*/ << 56)) : "Offset is too big!";
    //assert (Offset.getQuantity() >= -(1L/*LL*/ << 56)) : "Offset is too small!";
    
    Value = Offset;//(((long/*uint64_t*/)(Offset.getQuantity())) << 3) | ComponentKind.getValue();
    Value$Kind = (byte)ComponentKind.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::VTableComponent">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 185,
   FQN="clang::VTableComponent::VTableComponent", NM="_ZN5clang15VTableComponentC1ENS0_4KindEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang15VTableComponentC1ENS0_4KindEj")
  //</editor-fold>
  private VTableComponent(Kind ComponentKind, Decl/*uintptr_t*/ Ptr) {
    assert ((isRTTIKind(ComponentKind) || isFunctionPointerKind(ComponentKind))) : "Invalid component kind!";
    //assert ((Ptr & 7) == 0) : "Pointer not sufficiently aligned!";
    
    Value = Ptr;//$uint2long(Ptr | ComponentKind.getValue());
    Value$Kind = (byte)ComponentKind.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::getOffset">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 194,
   FQN="clang::VTableComponent::getOffset", NM="_ZNK5clang15VTableComponent9getOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZNK5clang15VTableComponent9getOffsetEv")
  //</editor-fold>
  private CharUnits getOffset() /*const*/ {
    assert ((getKind() == Kind.CK_VCallOffset || getKind() == Kind.CK_VBaseOffset || getKind() == Kind.CK_OffsetToTop)) : "Invalid component kind!";
    
    return (CharUnits)Value;//CharUnits.fromQuantity(Value >> 3);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::getPointer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 201,
   FQN="clang::VTableComponent::getPointer", NM="_ZNK5clang15VTableComponent10getPointerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZNK5clang15VTableComponent10getPointerEv")
  //</editor-fold>
  private Object/*uintptr_t*/ getPointer() /*const*/ {
    assert ((getKind() == Kind.CK_RTTI || isFunctionPointerKind())) : "Invalid component kind!";
    
    return Value;//((/*static_cast*/Object/*uintptr_t*/)($ullong2uintptr_t(Value & ~7L/*ULL*/)));
  }

  
//  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::VTableComponent">
//  @Converted(kind = Converted.Kind.DELETED, //investigate clients
//   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 208,
//   FQN="clang::VTableComponent::VTableComponent", NM="_ZN5clang15VTableComponentC1Ey",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang15VTableComponentC1Ey")
//  //</editor-fold>
//  private /*explicit*/ VTableComponent(long/*uint64_t*/ Value) {
//    // : Value(Value) 
//    //START JInit
//    this.Value = Value;
//    //END JInit
//  }

  
  /// The kind is stored in the lower 3 bits of the value. For offsets, we
  /// make use of the facts that classes can't be larger than 2^55 bytes,
  /// so we store the offset in the lower part of the 61 bits that remain.
  /// (The reason that we're not simply using a PointerIntPair here is that we
  /// need the offsets to be 64-bit, even when on a 32-bit machine).
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private Object /*int64_t*/ Value;
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private byte Value$Kind;
  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::VTableComponent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 31,
   FQN="clang::VTableComponent::VTableComponent", NM="_ZN5clang15VTableComponentC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang15VTableComponentC1ERKS0_")
  //</editor-fold>
  public /*inline*/ VTableComponent(final /*const*/ VTableComponent /*&*/ $Prm0) {
    // : Value(.Value) 
    //START JInit
    this.Value = $Prm0.Value;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::VTableComponent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 31,
   FQN="clang::VTableComponent::VTableComponent", NM="_ZN5clang15VTableComponentC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZN5clang15VTableComponentC1EOS0_")
  //</editor-fold>
  public /*inline*/ VTableComponent(JD$Move _dparam, final VTableComponent /*&&*/$Prm0) {
    // : Value(static_cast<VTableComponent &&>().Value) 
    //START JInit
    this.Value = $Prm0.Value;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::VTableComponent::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 31,
   FQN="clang::VTableComponent::operator=", NM="_ZN5clang15VTableComponentaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang15VTableComponentaSERKS0_")
  //</editor-fold>
  public /*inline*/ VTableComponent /*&*/ $assign(final /*const*/ VTableComponent /*&*/ $Prm0) {
    this.Value = $Prm0.Value;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "Value=" + Value; // NOI18N
  }
}
