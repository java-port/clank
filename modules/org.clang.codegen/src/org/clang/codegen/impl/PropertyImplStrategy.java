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

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.codegen.impl.CGObjCStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PropertyImplStrategy">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 619,
 FQN="(anonymous namespace)::PropertyImplStrategy", NM="_ZN12_GLOBAL__N_120PropertyImplStrategyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_120PropertyImplStrategyE")
//</editor-fold>
public class PropertyImplStrategy {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PropertyImplStrategy::StrategyKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 621,
   FQN="(anonymous namespace)::PropertyImplStrategy::StrategyKind", NM="_ZN12_GLOBAL__N_120PropertyImplStrategy12StrategyKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_120PropertyImplStrategy12StrategyKindE")
  //</editor-fold>
  public enum StrategyKind implements Native.NativeUIntEnum {
    /// The 'native' strategy is to use the architecture's provided
    /// reads and writes.
    Native(0),
    
    /// Use objc_setProperty and objc_getProperty.
    GetSetProperty(Native.getValue() + 1),
    
    /// Use objc_setProperty for the setter, but use expression
    /// evaluation for the getter.
    SetPropertyAndExpressionGet(GetSetProperty.getValue() + 1),
    
    /// Use objc_copyStruct.
    CopyStruct(SetPropertyAndExpressionGet.getValue() + 1),
    
    /// The 'expression' strategy is to emit normal assignment or
    /// lvalue-to-rvalue expressions.
    Expression(CopyStruct.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static StrategyKind valueOf(int val) {
      StrategyKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final StrategyKind[] VALUES;
      private static final StrategyKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (StrategyKind kind : StrategyKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new StrategyKind[min < 0 ? (1-min) : 0];
        VALUES = new StrategyKind[max >= 0 ? (1+max) : 0];
        for (StrategyKind kind : StrategyKind.values()) {
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
    private StrategyKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PropertyImplStrategy::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 641,
   FQN="(anonymous namespace)::PropertyImplStrategy::getKind", NM="_ZNK12_GLOBAL__N_120PropertyImplStrategy7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZNK12_GLOBAL__N_120PropertyImplStrategy7getKindEv")
  //</editor-fold>
  public StrategyKind getKind() /*const*/ {
    return StrategyKind.valueOf($8bits_uint2uint(Kind));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PropertyImplStrategy::hasStrongMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 643,
   FQN="(anonymous namespace)::PropertyImplStrategy::hasStrongMember", NM="_ZNK12_GLOBAL__N_120PropertyImplStrategy15hasStrongMemberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZNK12_GLOBAL__N_120PropertyImplStrategy15hasStrongMemberEv")
  //</editor-fold>
  public boolean hasStrongMember() /*const*/ {
    return HasStrong;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PropertyImplStrategy::isAtomic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 644,
   FQN="(anonymous namespace)::PropertyImplStrategy::isAtomic", NM="_ZNK12_GLOBAL__N_120PropertyImplStrategy8isAtomicEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZNK12_GLOBAL__N_120PropertyImplStrategy8isAtomicEv")
  //</editor-fold>
  public boolean isAtomic() /*const*/ {
    return IsAtomic;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PropertyImplStrategy::isCopy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 645,
   FQN="(anonymous namespace)::PropertyImplStrategy::isCopy", NM="_ZNK12_GLOBAL__N_120PropertyImplStrategy6isCopyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZNK12_GLOBAL__N_120PropertyImplStrategy6isCopyEv")
  //</editor-fold>
  public boolean isCopy() /*const*/ {
    return IsCopy;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PropertyImplStrategy::getIvarSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 647,
   FQN="(anonymous namespace)::PropertyImplStrategy::getIvarSize", NM="_ZNK12_GLOBAL__N_120PropertyImplStrategy11getIvarSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZNK12_GLOBAL__N_120PropertyImplStrategy11getIvarSizeEv")
  //</editor-fold>
  public CharUnits getIvarSize() /*const*/ {
    return new CharUnits(IvarSize);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PropertyImplStrategy::getIvarAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 648,
   FQN="(anonymous namespace)::PropertyImplStrategy::getIvarAlignment", NM="_ZNK12_GLOBAL__N_120PropertyImplStrategy16getIvarAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZNK12_GLOBAL__N_120PropertyImplStrategy16getIvarAlignmentEv")
  //</editor-fold>
  public CharUnits getIvarAlignment() /*const*/ {
    return new CharUnits(IvarAlignment);
  }

  
  
  /// Pick an implementation strategy for the given property synthesis.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PropertyImplStrategy::PropertyImplStrategy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 665,
   FQN="(anonymous namespace)::PropertyImplStrategy::PropertyImplStrategy", NM="_ZN12_GLOBAL__N_120PropertyImplStrategyC1ERN5clang7CodeGen13CodeGenModuleEPKNS1_20ObjCPropertyImplDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_120PropertyImplStrategyC1ERN5clang7CodeGen13CodeGenModuleEPKNS1_20ObjCPropertyImplDeclE")
  //</editor-fold>
  public PropertyImplStrategy(final CodeGenModule /*&*/ CGM, 
      /*const*/ ObjCPropertyImplDecl /*P*/ propImpl) {
    // : IvarSize(), IvarAlignment() 
    //START JInit
    this.IvarSize = new CharUnits();
    this.IvarAlignment = new CharUnits();
    //END JInit
    /*const*/ ObjCPropertyDecl /*P*/ prop = propImpl.getPropertyDecl();
    ObjCPropertyDecl.SetterKind setterKind = prop.getSetterKind();
    
    IsCopy = (setterKind == ObjCPropertyDecl.SetterKind.Copy);
    IsAtomic = prop.isAtomic();
    HasStrong = false; // doesn't matter here.
    
    // Evaluate the ivar's size and alignment.
    ObjCIvarDecl /*P*/ ivar = propImpl.getPropertyIvarDecl();
    QualType ivarType = ivar.getType();
    std.tie(IvarSize, IvarAlignment).$assign(
        CGM.getContext().getTypeInfoInChars(new QualType(ivarType))
    );
    
    // If we have a copy property, we always have to use getProperty/setProperty.
    // TODO: we could actually use setProperty and an expression for non-atomics.
    if (IsCopy) {
      Kind = $uint2uint_8bits(StrategyKind.GetSetProperty.getValue());
      return;
    }
    
    // Handle retain.
    if (setterKind == ObjCPropertyDecl.SetterKind.Retain) {
      // In GC-only, there's nothing special that needs to be done.
      if (CGM.getLangOpts().getGC() == LangOptions.GCMode.GCOnly) {

        // fallthrough

        // In ARC, if the property is non-atomic, use expression emission,
        // which translates to objc_storeStrong.  This isn't required, but
        // it's slightly nicer.
      } else if (CGM.getLangOpts().ObjCAutoRefCount && !IsAtomic) {
        // Using standard expression emission for the setter is only
        // acceptable if the ivar is __strong, which won't be true if
        // the property is annotated with __attribute__((NSObject)).
        // TODO: falling all the way back to objc_setProperty here is
        // just laziness, though;  we could still use objc_storeStrong
        // if we hacked it right.
        if (ivarType.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Strong) {
          Kind = $uint2uint_8bits(StrategyKind.Expression.getValue());
        } else {
          Kind = $uint2uint_8bits(StrategyKind.SetPropertyAndExpressionGet.getValue());
        }
        return;
        // Otherwise, we need to at least use setProperty.  However, if
        // the property isn't atomic, we can use normal expression
        // emission for the getter.
      } else if (!IsAtomic) {
        Kind = $uint2uint_8bits(StrategyKind.SetPropertyAndExpressionGet.getValue());
        return;
        // Otherwise, we have to use both setProperty and getProperty.
      } else {
        Kind = $uint2uint_8bits(StrategyKind.GetSetProperty.getValue());
        return;
      }
    }
    
    // If we're not atomic, just use expression accesses.
    if (!IsAtomic) {
      Kind = $uint2uint_8bits(StrategyKind.Expression.getValue());
      return;
    }
    
    // Properties on bitfield ivars need to be emitted using expression
    // accesses even if they're nominally atomic.
    if (ivar.isBitField()) {
      Kind = $uint2uint_8bits(StrategyKind.Expression.getValue());
      return;
    }
    
    // GC-qualified or ARC-qualified ivars need to be emitted as
    // expressions.  This actually works out to being atomic anyway,
    // except for ARC __strong, but that should trigger the above code.
    if (ivarType.hasNonTrivialObjCLifetime()
       || ((CGM.getLangOpts().getGC().getValue() != 0)
       && (CGM.getContext().getObjCGCAttrKind(new QualType(ivarType)).getValue() != 0))) {
      Kind = $uint2uint_8bits(StrategyKind.Expression.getValue());
      return;
    }
    
    // Compute whether the ivar has strong members.
    if ((CGM.getLangOpts().getGC().getValue() != 0)) {
      {
        /*const*/ RecordType /*P*/ recordType = ivarType.$arrow().getAs$RecordType();
        if ((recordType != null)) {
          HasStrong = recordType.getDecl().hasObjectMember();
        }
      }
    }
    
    // We can never access structs with object members with a native
    // access, because we need to use write barriers.  This is what
    // objc_copyStruct is for.
    if (HasStrong) {
      Kind = $uint2uint_8bits(StrategyKind.CopyStruct.getValue());
      return;
    }
    
    // Otherwise, this is target-dependent and based on the size and
    // alignment of the ivar.
    
    // If the size of the ivar is not a power of two, give up.  We don't
    // want to get into the business of doing compare-and-swaps.
    if (!IvarSize.isPowerOfTwo()) {
      Kind = $uint2uint_8bits(StrategyKind.CopyStruct.getValue());
      return;
    }
    
    Triple.ArchType arch = CGM.getTarget().getTriple().getArch();
    
    // Most architectures require memory to fit within a single cache
    // line, so the alignment has to be at least the size of the access.
    // Otherwise we have to grab a lock.
    if (IvarAlignment.$less(IvarSize) && !hasUnalignedAtomics(arch)) {
      Kind = $uint2uint_8bits(StrategyKind.CopyStruct.getValue());
      return;
    }
    
    // If the ivar's size exceeds the architecture's maximum atomic
    // access size, we have to use CopyStruct.
    if (IvarSize.$greater(getMaxAtomicAccessSize(CGM, arch))) {
      Kind = $uint2uint_8bits(StrategyKind.CopyStruct.getValue());
      return;
    }
    
    // Otherwise, we can use native loads and stores.
    Kind = $uint2uint_8bits(StrategyKind.Native.getValue());
  }

/*private:*/
  private /*JBYTE unsigned int*/ byte Kind /*: 8*/;
  private /*JBIT unsigned int*/ boolean IsAtomic /*: 1*/;
  private /*JBIT unsigned int*/ boolean IsCopy /*: 1*/;
  private /*JBIT unsigned int*/ boolean HasStrong /*: 1*/;
  
  private CharUnits IvarSize;
  private CharUnits IvarAlignment;
  
  @Override public String toString() {
    return "" + "Kind=" + $uchar2uint(Kind) // NOI18N
              + ", IsAtomic=" + IsAtomic // NOI18N
              + ", IsCopy=" + IsCopy // NOI18N
              + ", HasStrong=" + HasStrong // NOI18N
              + ", IvarSize=" + IvarSize // NOI18N
              + ", IvarAlignment=" + IvarAlignment; // NOI18N
  }
}
