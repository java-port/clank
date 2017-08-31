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

package org.clang.sema.impl;

import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.sema.*;
import static org.clang.ast.java.AstTypesRTTI.*;


/// A helper class to unwrap a type down to a function for the
/// purposes of applying attributes there.
///
/// Use:
///   FunctionTypeUnwrapper unwrapped(SemaRef, T);
///   if (unwrapped.isFunctionType()) {
///     const FunctionType *fn = unwrapped.get();
///     // change fn somehow
///     T = unwrapped.wrap(fn);
///   }
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FunctionTypeUnwrapper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5619,
 FQN="(anonymous namespace)::FunctionTypeUnwrapper", NM="_ZN12_GLOBAL__N_121FunctionTypeUnwrapperE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_121FunctionTypeUnwrapperE")
//</editor-fold>
public class/*struct*/ FunctionTypeUnwrapper implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FunctionTypeUnwrapper::WrapKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5620,
   FQN="(anonymous namespace)::FunctionTypeUnwrapper::WrapKind", NM="_ZN12_GLOBAL__N_121FunctionTypeUnwrapper8WrapKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_121FunctionTypeUnwrapper8WrapKindE")
  //</editor-fold>
  public enum WrapKind implements Native.ComparableLower {
    Desugar(0),
    Attributed(Desugar.getValue() + 1),
    Parens(Attributed.getValue() + 1),
    Pointer(Parens.getValue() + 1),
    BlockPointer(Pointer.getValue() + 1),
    Reference(BlockPointer.getValue() + 1),
    MemberPointer(Reference.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static WrapKind valueOf(int val) {
      WrapKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final WrapKind[] VALUES;
      private static final WrapKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (WrapKind kind : WrapKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new WrapKind[min < 0 ? (1-min) : 0];
        VALUES = new WrapKind[max >= 0 ? (1+max) : 0];
        for (WrapKind kind : WrapKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private WrapKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((WrapKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((WrapKind)obj).value);}
    //</editor-fold>
  };
  
  public QualType Original;
  public /*const*/ FunctionType /*P*/ Fn;
  public SmallVectorUChar Stack;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FunctionTypeUnwrapper::FunctionTypeUnwrapper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5634,
   FQN="(anonymous namespace)::FunctionTypeUnwrapper::FunctionTypeUnwrapper", NM="_ZN12_GLOBAL__N_121FunctionTypeUnwrapperC1ERN5clang4SemaENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_121FunctionTypeUnwrapperC1ERN5clang4SemaENS1_8QualTypeE")
  //</editor-fold>
  public FunctionTypeUnwrapper(final Sema /*&*/ S, QualType T) {
    // : Original(T), Stack() 
    //START JInit
    this.Original = new QualType(T);
    this.Stack = new SmallVectorUChar(8, (byte)0);
    //END JInit
    while (true) {
      /*const*/ Type /*P*/ Ty = T.getTypePtr();
      if (isa_FunctionType(Ty)) {
        Fn = cast_FunctionType(Ty);
        return;
      } else if (isa_ParenType(Ty)) {
        T.$assignMove(cast_ParenType(Ty).getInnerType());
        Stack.push_back((byte)WrapKind.Parens.getValue());
      } else if (isa_PointerType(Ty)) {
        T.$assignMove(cast_PointerType(Ty).getPointeeType());
        Stack.push_back((byte)WrapKind.Pointer.getValue());
      } else if (isa_BlockPointerType(Ty)) {
        T.$assignMove(cast_BlockPointerType(Ty).getPointeeType());
        Stack.push_back((byte)WrapKind.BlockPointer.getValue());
      } else if (isa_MemberPointerType(Ty)) {
        T.$assignMove(cast_MemberPointerType(Ty).getPointeeType());
        Stack.push_back((byte)WrapKind.MemberPointer.getValue());
      } else if (isa_ReferenceType(Ty)) {
        T.$assignMove(cast_ReferenceType(Ty).getPointeeType());
        Stack.push_back((byte)WrapKind.Reference.getValue());
      } else if (isa_AttributedType(Ty)) {
        T.$assignMove(cast_AttributedType(Ty).getEquivalentType());
        Stack.push_back((byte)WrapKind.Attributed.getValue());
      } else {
        /*const*/ Type /*P*/ DTy = Ty.getUnqualifiedDesugaredType();
        if (Ty == DTy) {
          Fn = null;
          return;
        }
        
        T.$assignMove(new QualType(DTy, 0));
        Stack.push_back((byte)WrapKind.Desugar.getValue());
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FunctionTypeUnwrapper::isFunctionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5671,
   FQN="(anonymous namespace)::FunctionTypeUnwrapper::isFunctionType", NM="_ZNK12_GLOBAL__N_121FunctionTypeUnwrapper14isFunctionTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK12_GLOBAL__N_121FunctionTypeUnwrapper14isFunctionTypeEv")
  //</editor-fold>
  public boolean isFunctionType() /*const*/ {
    return (Fn != null);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FunctionTypeUnwrapper::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5672,
   FQN="(anonymous namespace)::FunctionTypeUnwrapper::get", NM="_ZNK12_GLOBAL__N_121FunctionTypeUnwrapper3getEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK12_GLOBAL__N_121FunctionTypeUnwrapper3getEv")
  //</editor-fold>
  public /*const*/ FunctionType /*P*/ get() /*const*/ {
    return Fn;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FunctionTypeUnwrapper::wrap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5674,
   FQN="(anonymous namespace)::FunctionTypeUnwrapper::wrap", NM="_ZN12_GLOBAL__N_121FunctionTypeUnwrapper4wrapERN5clang4SemaEPKNS1_12FunctionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_121FunctionTypeUnwrapper4wrapERN5clang4SemaEPKNS1_12FunctionTypeE")
  //</editor-fold>
  public QualType wrap(final Sema /*&*/ S, /*const*/ FunctionType /*P*/ New) {
    // If T wasn't modified from the unwrapped type, do nothing.
    if (New == get()) {
      return new QualType(Original);
    }
    
    Fn = New;
    return wrap(S.Context, new QualType(Original), 0);
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FunctionTypeUnwrapper::wrap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5683,
   FQN="(anonymous namespace)::FunctionTypeUnwrapper::wrap", NM="_ZN12_GLOBAL__N_121FunctionTypeUnwrapper4wrapERN5clang10ASTContextENS1_8QualTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_121FunctionTypeUnwrapper4wrapERN5clang10ASTContextENS1_8QualTypeEj")
  //</editor-fold>
  private QualType wrap(final ASTContext /*&*/ C, QualType Old, /*uint*/int I) {
    if (I == Stack.size()) {
      return C.getQualifiedType(Fn, Old.getQualifiers());
    }
    
    // Build up the inner type, applying the qualifiers from the old
    // type to the new type.
    SplitQualType SplitOld = Old.split();
    
    // As a special case, tail-recurse if there are no qualifiers.
    if (SplitOld.Quals.empty()) {
      return wrap(C, SplitOld.Ty, I);
    }
    return C.getQualifiedType(wrap(C, SplitOld.Ty, I), new Qualifiers(SplitOld.Quals));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FunctionTypeUnwrapper::wrap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5697,
   FQN="(anonymous namespace)::FunctionTypeUnwrapper::wrap", NM="_ZN12_GLOBAL__N_121FunctionTypeUnwrapper4wrapERN5clang10ASTContextEPKNS1_4TypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_121FunctionTypeUnwrapper4wrapERN5clang10ASTContextEPKNS1_4TypeEj")
  //</editor-fold>
  private QualType wrap(final ASTContext /*&*/ C, /*const*/ Type /*P*/ Old, /*uint*/int I) {
    if (I == Stack.size()) {
      return new QualType(Fn, 0);
    }
    switch (/*static_cast*/WrapKind.valueOf(Stack.$at(I++))) {
     case Desugar:
      // This is the point at which we potentially lose source
      // information.
      return wrap(C, Old.getUnqualifiedDesugaredType(), I);
     case Attributed:
      return wrap(C, cast_AttributedType(Old).getEquivalentType(), I);
     case Parens:
      {
        QualType New = wrap(C, cast_ParenType(Old).getInnerType(), I);
        return C.getParenType(new QualType(New));
      }
     case Pointer:
      {
        QualType New = wrap(C, cast_PointerType(Old).getPointeeType(), I);
        return C.getPointerType(new QualType(New));
      }
     case BlockPointer:
      {
        QualType New = wrap(C, cast_BlockPointerType(Old).getPointeeType(), I);
        return C.getBlockPointerType(new QualType(New));
      }
     case MemberPointer:
      {
        /*const*/ MemberPointerType /*P*/ OldMPT = cast_MemberPointerType(Old);
        QualType New = wrap(C, OldMPT.getPointeeType(), I);
        return C.getMemberPointerType(new QualType(New), OldMPT.__getClass());
      }
     case Reference:
      {
        /*const*/ ReferenceType /*P*/ OldRef = cast_ReferenceType(Old);
        QualType New = wrap(C, OldRef.getPointeeType(), I);
        if (isa_LValueReferenceType(OldRef)) {
          return C.getLValueReferenceType(new QualType(New), OldRef.isSpelledAsLValue());
        } else {
          return C.getRValueReferenceType(new QualType(New));
        }
      }
    }
    throw new llvm_unreachable("unknown wrapping kind");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FunctionTypeUnwrapper::~FunctionTypeUnwrapper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5619,
   FQN="(anonymous namespace)::FunctionTypeUnwrapper::~FunctionTypeUnwrapper", NM="_ZN12_GLOBAL__N_121FunctionTypeUnwrapperD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_121FunctionTypeUnwrapperD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Stack.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Original=" + Original // NOI18N
              + ", Fn=" + Fn // NOI18N
              + ", Stack=" + Stack; // NOI18N
  }
}
