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

package org.llvm.ir.impl;

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.ir.*;
import org.llvm.llvmc.LLVMOpaqueAttributeRef;
import org.llvm.support.*;
import static org.llvm.support.llvm.*;


//===----------------------------------------------------------------------===//
/// \class
/// \brief This class represents a single, uniqued attribute. That attribute
/// could be a single enum, a tuple, or a string.
//<editor-fold defaultstate="collapsed" desc="llvm::AttributeImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 36,
 FQN="llvm::AttributeImpl", NM="_ZN4llvm13AttributeImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm13AttributeImplE")
//</editor-fold>
public class AttributeImpl extends FoldingSetImpl.NodeImpl implements /*public*/ FoldingSetImpl.Node, Destructors.ClassWithDestructor, LLVMOpaqueAttributeRef {
  private /*uchar*/byte KindID; ///< Holds the AttrEntryKind of the attribute
  
  // AttributesImpl is uniqued, these should not be publicly available.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeImpl::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 40,
   FQN="llvm::AttributeImpl::operator=", NM="_ZN4llvm13AttributeImplaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm13AttributeImplaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ AttributeImpl /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeImpl::AttributeImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 41,
   FQN="llvm::AttributeImpl::AttributeImpl", NM="_ZN4llvm13AttributeImplC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm13AttributeImplC1ERKS0_")
  //</editor-fold>
  protected/*private*/ AttributeImpl(final /*const*/ AttributeImpl /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeImpl::AttrEntryKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 44,
   FQN="llvm::AttributeImpl::AttrEntryKind", NM="_ZN4llvm13AttributeImpl13AttrEntryKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm13AttributeImpl13AttrEntryKindE")
  //</editor-fold>
  protected enum AttrEntryKind implements Native.NativeUIntEnum {
    EnumAttrEntry(0),
    IntAttrEntry(EnumAttrEntry.getValue() + 1),
    StringAttrEntry(IntAttrEntry.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static AttrEntryKind valueOf(int val) {
      AttrEntryKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final AttrEntryKind[] VALUES;
      private static final AttrEntryKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (AttrEntryKind kind : AttrEntryKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new AttrEntryKind[min < 0 ? (1-min) : 0];
        VALUES = new AttrEntryKind[max >= 0 ? (1+max) : 0];
        for (AttrEntryKind kind : AttrEntryKind.values()) {
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
    private AttrEntryKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeImpl::AttributeImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 50,
   FQN="llvm::AttributeImpl::AttributeImpl", NM="_ZN4llvm13AttributeImplC1ENS0_13AttrEntryKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm13AttributeImplC1ENS0_13AttrEntryKindE")
  //</editor-fold>
  protected AttributeImpl(AttrEntryKind KindID) {
    // : FoldingSetNode(), KindID(KindID) 
    //START JInit
    $Node();
    this.KindID = (byte)KindID.getValue();
    //END JInit
  }

/*public:*/
  
  //===----------------------------------------------------------------------===//
  // AttributeImpl Definition
  //===----------------------------------------------------------------------===//
  
  // Pin the vtables to this file.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeImpl::~AttributeImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 406,
   FQN="llvm::AttributeImpl::~AttributeImpl", NM="_ZN4llvm13AttributeImplD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm13AttributeImplD0Ev")
  //</editor-fold>
  public void $destroy() {
    FoldingSetImpl.Node.super.$destroy$Node();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeImpl::isEnumAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 55,
   FQN="llvm::AttributeImpl::isEnumAttribute", NM="_ZNK4llvm13AttributeImpl15isEnumAttributeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm13AttributeImpl15isEnumAttributeEv")
  //</editor-fold>
  public boolean isEnumAttribute() /*const*/ {
    return $uchar2int(KindID) == AttrEntryKind.EnumAttrEntry.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeImpl::isIntAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 56,
   FQN="llvm::AttributeImpl::isIntAttribute", NM="_ZNK4llvm13AttributeImpl14isIntAttributeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm13AttributeImpl14isIntAttributeEv")
  //</editor-fold>
  public boolean isIntAttribute() /*const*/ {
    return $uchar2int(KindID) == AttrEntryKind.IntAttrEntry.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeImpl::isStringAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 57,
   FQN="llvm::AttributeImpl::isStringAttribute", NM="_ZNK4llvm13AttributeImpl17isStringAttributeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm13AttributeImpl17isStringAttributeEv")
  //</editor-fold>
  public boolean isStringAttribute() /*const*/ {
    return $uchar2int(KindID) == AttrEntryKind.StringAttrEntry.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeImpl::hasAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 411,
   FQN="llvm::AttributeImpl::hasAttribute", NM="_ZNK4llvm13AttributeImpl12hasAttributeENS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm13AttributeImpl12hasAttributeENS_9Attribute8AttrKindE")
  //</editor-fold>
  public boolean hasAttribute(Attribute.AttrKind A) /*const*/ {
    if (isStringAttribute()) {
      return false;
    }
    return getKindAsEnum() == A;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeImpl::hasAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 416,
   FQN="llvm::AttributeImpl::hasAttribute", NM="_ZNK4llvm13AttributeImpl12hasAttributeENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm13AttributeImpl12hasAttributeENS_9StringRefE")
  //</editor-fold>
  public boolean hasAttribute(StringRef Kind) /*const*/ {
    if (!isStringAttribute()) {
      return false;
    }
    return $eq_StringRef(getKindAsString(), /*NO_COPY*/Kind);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeImpl::getKindAsEnum">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 421,
   FQN="llvm::AttributeImpl::getKindAsEnum", NM="_ZNK4llvm13AttributeImpl13getKindAsEnumEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm13AttributeImpl13getKindAsEnumEv")
  //</editor-fold>
  public Attribute.AttrKind getKindAsEnum() /*const*/ {
    assert (isEnumAttribute() || isIntAttribute());
    return ((/*static_cast*//*const*/ EnumAttributeImpl /*P*/ )(this)).getEnumKind();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeImpl::getValueAsInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 426,
   FQN="llvm::AttributeImpl::getValueAsInt", NM="_ZNK4llvm13AttributeImpl13getValueAsIntEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm13AttributeImpl13getValueAsIntEv")
  //</editor-fold>
  public long/*uint64_t*/ getValueAsInt() /*const*/ {
    assert (isIntAttribute());
    return ((/*static_cast*//*const*/ IntAttributeImpl /*P*/ )(this)).getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeImpl::getKindAsString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 431,
   FQN="llvm::AttributeImpl::getKindAsString", NM="_ZNK4llvm13AttributeImpl15getKindAsStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm13AttributeImpl15getKindAsStringEv")
  //</editor-fold>
  public StringRef getKindAsString() /*const*/ {
    assert (isStringAttribute());
    return ((/*static_cast*//*const*/ StringAttributeImpl /*P*/ )(this)).getStringKind();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeImpl::getValueAsString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 436,
   FQN="llvm::AttributeImpl::getValueAsString", NM="_ZNK4llvm13AttributeImpl16getValueAsStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm13AttributeImpl16getValueAsStringEv")
  //</editor-fold>
  public StringRef getValueAsString() /*const*/ {
    assert (isStringAttribute());
    return ((/*static_cast*//*const*/ StringAttributeImpl /*P*/ )(this)).getStringValue();
  }

  
  /// \brief Used when sorting the attributes.
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeImpl::operator<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 441,
   FQN="llvm::AttributeImpl::operator<", NM="_ZNK4llvm13AttributeImplltERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm13AttributeImplltERKS0_")
  //</editor-fold>
  public boolean $less(final /*const*/ AttributeImpl /*&*/ AI) /*const*/ {
    // This sorts the attributes with Attribute::AttrKinds coming first (sorted
    // relative to their enum value) and then strings.
    if (isEnumAttribute()) {
      if (AI.isEnumAttribute()) {
        return getKindAsEnum().getValue() < AI.getKindAsEnum().getValue();
      }
      if (AI.isIntAttribute()) {
        return true;
      }
      if (AI.isStringAttribute()) {
        return true;
      }
    }
    if (isIntAttribute()) {
      if (AI.isEnumAttribute()) {
        return false;
      }
      if (AI.isIntAttribute()) {
        if (getKindAsEnum() == AI.getKindAsEnum()) {
          return $less_ulong(getValueAsInt(), AI.getValueAsInt());
        }
        return getKindAsEnum().getValue() < AI.getKindAsEnum().getValue();
      }
      if (AI.isStringAttribute()) {
        return true;
      }
    }
    if (AI.isEnumAttribute()) {
      return false;
    }
    if (AI.isIntAttribute()) {
      return false;
    }
    if ($eq_StringRef(getKindAsString(), AI.getKindAsString())) {
      return $less_StringRef(getValueAsString(), AI.getValueAsString());
    }
    return $less_StringRef(getKindAsString(), AI.getKindAsString());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeImpl::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 71,
   FQN="llvm::AttributeImpl::Profile", NM="_ZNK4llvm13AttributeImpl7ProfileERNS_16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZNK4llvm13AttributeImpl7ProfileERNS_16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    if (isEnumAttribute()) {
      AttributeImpl.Profile(ID, getKindAsEnum(), $int2ulong(0));
    } else if (isIntAttribute()) {
      AttributeImpl.Profile(ID, getKindAsEnum(), getValueAsInt());
    } else {
      AttributeImpl.Profile(ID, getKindAsString(), getValueAsString());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeImpl::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 79,
   FQN="llvm::AttributeImpl::Profile", NM="_ZN4llvm13AttributeImpl7ProfileERNS_16FoldingSetNodeIDENS_9Attribute8AttrKindEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm13AttributeImpl7ProfileERNS_16FoldingSetNodeIDENS_9Attribute8AttrKindEy")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, Attribute.AttrKind Kind, 
         long/*uint64_t*/ Val) {
    ID.AddInteger_int(Kind.getValue());
    if ((Val != 0)) {
      ID.AddInteger_ullong(Val);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeImpl::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AttributeImpl.h", line = 84,
   FQN="llvm::AttributeImpl::Profile", NM="_ZN4llvm13AttributeImpl7ProfileERNS_16FoldingSetNodeIDENS_9StringRefES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm13AttributeImpl7ProfileERNS_16FoldingSetNodeIDENS_9StringRefES3_")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, StringRef Kind, StringRef Values) {
    ID.AddString(new StringRef(Kind));
    if (!Values.empty()) {
      ID.AddString(new StringRef(Values));
    }
  }

  
  // FIXME: Remove this!
  //<editor-fold defaultstate="collapsed" desc="llvm::AttributeImpl::getAttrMask">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 467,
   FQN="llvm::AttributeImpl::getAttrMask", NM="_ZN4llvm13AttributeImpl11getAttrMaskENS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm13AttributeImpl11getAttrMaskENS_9Attribute8AttrKindE")
  //</editor-fold>
  public static long/*uint64_t*/ getAttrMask(Attribute.AttrKind Val) {
    // FIXME: Remove this.
    switch (Val) {
     case EndAttrKinds:
      throw new llvm_unreachable("Synthetic enumerators which should never get here");
     case None:
      return $int2ulong(0);
     case ZExt:
      return $int2ulong(1 << 0);
     case SExt:
      return $int2ulong(1 << 1);
     case NoReturn:
      return $int2ulong(1 << 2);
     case InReg:
      return $int2ulong(1 << 3);
     case StructRet:
      return $int2ulong(1 << 4);
     case NoUnwind:
      return $int2ulong(1 << 5);
     case NoAlias:
      return $int2ulong(1 << 6);
     case ByVal:
      return $int2ulong(1 << 7);
     case Nest:
      return $int2ulong(1 << 8);
     case ReadNone:
      return $int2ulong(1 << 9);
     case ReadOnly:
      return $int2ulong(1 << 10);
     case NoInline:
      return $int2ulong(1 << 11);
     case AlwaysInline:
      return $int2ulong(1 << 12);
     case OptimizeForSize:
      return $int2ulong(1 << 13);
     case StackProtect:
      return $int2ulong(1 << 14);
     case StackProtectReq:
      return $int2ulong(1 << 15);
     case Alignment:
      return $int2ulong(31 << 16);
     case NoCapture:
      return $int2ulong(1 << 21);
     case NoRedZone:
      return $int2ulong(1 << 22);
     case NoImplicitFloat:
      return $int2ulong(1 << 23);
     case Naked:
      return $int2ulong(1 << 24);
     case InlineHint:
      return $int2ulong(1 << 25);
     case StackAlignment:
      return $int2ulong(7 << 26);
     case ReturnsTwice:
      return $int2ulong(1 << 29);
     case UWTable:
      return $int2ulong(1 << 30);
     case NonLazyBind:
      return $uint2ulong(1/*U*/ << 31);
     case SanitizeAddress:
      return 1L/*ULL*/ << 32;
     case MinSize:
      return 1L/*ULL*/ << 33;
     case NoDuplicate:
      return 1L/*ULL*/ << 34;
     case StackProtectStrong:
      return 1L/*ULL*/ << 35;
     case SanitizeThread:
      return 1L/*ULL*/ << 36;
     case SanitizeMemory:
      return 1L/*ULL*/ << 37;
     case NoBuiltin:
      return 1L/*ULL*/ << 38;
     case Returned:
      return 1L/*ULL*/ << 39;
     case Cold:
      return 1L/*ULL*/ << 40;
     case Builtin:
      return 1L/*ULL*/ << 41;
     case OptimizeNone:
      return 1L/*ULL*/ << 42;
     case InAlloca:
      return 1L/*ULL*/ << 43;
     case NonNull:
      return 1L/*ULL*/ << 44;
     case JumpTable:
      return 1L/*ULL*/ << 45;
     case Convergent:
      return 1L/*ULL*/ << 46;
     case SafeStack:
      return 1L/*ULL*/ << 47;
     case NoRecurse:
      return 1L/*ULL*/ << 48;
     case InaccessibleMemOnly:
      return 1L/*ULL*/ << 49;
     case InaccessibleMemOrArgMemOnly:
      return 1L/*ULL*/ << 50;
     case SwiftSelf:
      return 1L/*ULL*/ << 51;
     case SwiftError:
      return 1L/*ULL*/ << 52;
     case WriteOnly:
      return 1L/*ULL*/ << 53;
     case Dereferenceable:
      throw new llvm_unreachable("dereferenceable attribute not supported in raw format");
//      break;
     case DereferenceableOrNull:
      throw new llvm_unreachable("dereferenceable_or_null attribute not supported in raw format");
//      break;
     case ArgMemOnly:
      throw new llvm_unreachable("argmemonly attribute not supported in raw format");
//      break;
     case AllocSize:
      throw new llvm_unreachable("allocsize not supported in raw format");
//      break;
    }
    throw new llvm_unreachable("Unsupported attribute type");
  }

  
  @Override public String toString() {
    return "" + "KindID=" + $uchar2uint(KindID) // NOI18N
              + super.toString(); // NOI18N
  }
}
