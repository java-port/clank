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

package org.llvm.ir;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;


/// \brief Tagged DWARF-like metadata node.
///
/// A metadata node with a DWARF tag (i.e., a constant named \c DW_TAG_*,
/// defined in llvm/Support/Dwarf.h).  Called \a DINode because it's
/// potentially used for non-DWARF output.
//<editor-fold defaultstate="collapsed" desc="llvm::DINode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 135,
 FQN="llvm::DINode", NM="_ZN4llvm6DINodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm6DINodeE")
//</editor-fold>
public class DINode extends /*public*/ MDNode implements Destructors.ClassWithDestructor {
  /*friend  class LLVMContextImpl*/
  /*friend  class MDNode*/
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DINode::DINode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 140,
   FQN="llvm::DINode::DINode", NM="_ZN4llvm6DINodeC1ERNS_11LLVMContextEjNS_8Metadata11StorageTypeEjNS_8ArrayRefIPS3_EES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm6DINodeC1ERNS_11LLVMContextEjNS_8Metadata11StorageTypeEjNS_8ArrayRefIPS3_EES7_")
  //</editor-fold>
  protected DINode(final LLVMContext /*&*/ C, /*uint*/int ID, Metadata.StorageType Storage, /*uint*/int Tag, 
      ArrayRef<Metadata /*P*/ > Ops1) {
    this(C, ID, Storage, Tag, 
      Ops1, new ArrayRef<Metadata /*P*/ >(None, true));
  }
  protected DINode(final LLVMContext /*&*/ C, /*uint*/int ID, Metadata.StorageType Storage, /*uint*/int Tag, 
      ArrayRef<Metadata /*P*/ > Ops1, ArrayRef<Metadata /*P*/ > Ops2/*= None*/) {
    // : MDNode(C, ID, Storage, Ops1, Ops2) 
    //START JInit
    super(C, ID, Storage, new ArrayRef<Metadata /*P*/ >(Ops1), new ArrayRef<Metadata /*P*/ >(Ops2));
    //END JInit
    assert ($less_uint(Tag, 1/*U*/ << 16));
    SubclassData16 = $uint2ushort(Tag);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DINode::~DINode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 146,
   FQN="llvm::DINode::~DINode", NM="_ZN4llvm6DINodeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm6DINodeD0Ev")
  //</editor-fold>
  public/*protected*/ void $destroy()/* = default*/ {
    super.$destroy();
  }

  
  /*template <class Ty> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DINode::getOperandAs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 148,
   FQN="llvm::DINode::getOperandAs", NM="Tpl__ZNK4llvm6DINode12getOperandAsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=Tpl__ZNK4llvm6DINode12getOperandAsEj")
  //</editor-fold>
  protected </*class*/ Ty> Ty /*P*/ getOperandAs(Class<Ty> clazz,/*uint*/int I) /*const*/ {
    return cast_or_null(clazz,getOperand(I));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DINode::getStringOperand">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 152,
   FQN="llvm::DINode::getStringOperand", NM="_ZNK4llvm6DINode16getStringOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DINode16getStringOperandEj")
  //</editor-fold>
  protected StringRef getStringOperand(/*uint*/int I) /*const*/ {
    {
      MDString /*P*/ S = this.getOperandAs(MDString.class, I);
      if ((S != null)) {
        return S.getString();
      }
    }
    return new StringRef();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DINode::getCanonicalMDString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 158,
   FQN="llvm::DINode::getCanonicalMDString", NM="_ZN4llvm6DINode20getCanonicalMDStringERNS_11LLVMContextENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm6DINode20getCanonicalMDStringERNS_11LLVMContextENS_9StringRefE")
  //</editor-fold>
  protected static MDString /*P*/ getCanonicalMDString(final LLVMContext /*&*/ Context, StringRef S) {
    if (S.empty()) {
      return null;
    }
    return MDString.get(Context, new StringRef(S));
  }

  
  /// Allow subclasses to mutate the tag.
  //<editor-fold defaultstate="collapsed" desc="llvm::DINode::setTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 165,
   FQN="llvm::DINode::setTag", NM="_ZN4llvm6DINode6setTagEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm6DINode6setTagEj")
  //</editor-fold>
  protected void setTag(/*uint*/int Tag) {
    SubclassData16 = $uint2ushort(Tag);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DINode::getTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 168,
   FQN="llvm::DINode::getTag", NM="_ZNK4llvm6DINode6getTagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DINode6getTagEv")
  //</editor-fold>
  public /*uint*/int getTag() /*const*/ {
    return $ushort2uint(SubclassData16);
  }

  
  /// \brief Debug info flags.
  ///
  /// The three accessibility flags are mutually exclusive and rolled together
  /// in the first two bits.
  //<editor-fold defaultstate="collapsed" desc="llvm::DINode::DIFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 174,
   FQN="llvm::DINode::DIFlags", NM="_ZN4llvm6DINode7DIFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm6DINode7DIFlagsE")
  //</editor-fold>
  public static final class/*enum*/ DIFlags {
    public static final /*uint*/int FlagPrivate = 1;
    public static final /*uint*/int FlagProtected = 2;
    public static final /*uint*/int FlagPublic = 3;
    public static final /*uint*/int FlagFwdDecl = (1 << 2);
    public static final /*uint*/int FlagAppleBlock = (1 << 3);
    public static final /*uint*/int FlagBlockByrefStruct = (1 << 4);
    public static final /*uint*/int FlagVirtual = (1 << 5);
    public static final /*uint*/int FlagArtificial = (1 << 6);
    public static final /*uint*/int FlagExplicit = (1 << 7);
    public static final /*uint*/int FlagPrototyped = (1 << 8);
    public static final /*uint*/int FlagObjcClassComplete = (1 << 9);
    public static final /*uint*/int FlagObjectPointer = (1 << 10);
    public static final /*uint*/int FlagVector = (1 << 11);
    public static final /*uint*/int FlagStaticMember = (1 << 12);
    public static final /*uint*/int FlagLValueReference = (1 << 13);
    public static final /*uint*/int FlagRValueReference = (1 << 14);
    public static final /*uint*/int FlagExternalTypeRef = (1 << 15);
    public static final /*uint*/int FlagSingleInheritance = (1 << 16);
    public static final /*uint*/int FlagMultipleInheritance = (2 << 16);
    public static final /*uint*/int FlagVirtualInheritance = (3 << 16);
    public static final /*uint*/int FlagIntroducedVirtual = (1 << 18);
    public static final /*uint*/int FlagBitField = (1 << 19);
    public static final /*uint*/int FlagAccessibility = DIFlags.FlagPrivate | DIFlags.FlagProtected | DIFlags.FlagPublic;
    public static final /*uint*/int FlagPtrToMemberRep = DIFlags.FlagSingleInheritance | DIFlags.FlagMultipleInheritance
       | DIFlags.FlagVirtualInheritance;
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DINode::getFlag">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 68,
   FQN="llvm::DINode::getFlag", NM="_ZN4llvm6DINode7getFlagENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm6DINode7getFlagENS_9StringRefE")
  //</editor-fold>
  public static /*uint*/int getFlag(StringRef Flag) {
    return new StringSwitchUInt(/*NO_COPY*/Flag).Case(/*KEEP_STR*/"DIFlagPrivate", DIFlags.FlagPrivate).
        Case(/*KEEP_STR*/"DIFlagProtected", DIFlags.FlagProtected).
        Case(/*KEEP_STR*/"DIFlagPublic", DIFlags.FlagPublic).
        Case(/*KEEP_STR*/"DIFlagFwdDecl", DIFlags.FlagFwdDecl).
        Case(/*KEEP_STR*/"DIFlagAppleBlock", DIFlags.FlagAppleBlock).
        Case(/*KEEP_STR*/"DIFlagBlockByrefStruct", DIFlags.FlagBlockByrefStruct).
        Case(/*KEEP_STR*/"DIFlagVirtual", DIFlags.FlagVirtual).
        Case(/*KEEP_STR*/"DIFlagArtificial", DIFlags.FlagArtificial).
        Case(/*KEEP_STR*/"DIFlagExplicit", DIFlags.FlagExplicit).
        Case(/*KEEP_STR*/"DIFlagPrototyped", DIFlags.FlagPrototyped).
        Case(/*KEEP_STR*/"DIFlagObjcClassComplete", DIFlags.FlagObjcClassComplete).
        Case(/*KEEP_STR*/"DIFlagObjectPointer", DIFlags.FlagObjectPointer).
        Case(/*KEEP_STR*/"DIFlagVector", DIFlags.FlagVector).
        Case(/*KEEP_STR*/"DIFlagStaticMember", DIFlags.FlagStaticMember).
        Case(/*KEEP_STR*/"DIFlagLValueReference", DIFlags.FlagLValueReference).
        Case(/*KEEP_STR*/"DIFlagRValueReference", DIFlags.FlagRValueReference).
        Case(/*KEEP_STR*/"DIFlagExternalTypeRef", DIFlags.FlagExternalTypeRef).
        Case(/*KEEP_STR*/"DIFlagSingleInheritance", DIFlags.FlagSingleInheritance).
        Case(/*KEEP_STR*/"DIFlagMultipleInheritance", DIFlags.FlagMultipleInheritance).
        Case(/*KEEP_STR*/"DIFlagVirtualInheritance", DIFlags.FlagVirtualInheritance).
        Case(/*KEEP_STR*/"DIFlagIntroducedVirtual", DIFlags.FlagIntroducedVirtual).
        Case(/*KEEP_STR*/"DIFlagBitField", DIFlags.FlagBitField).
        Default(0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DINode::getFlagString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 75,
   FQN="llvm::DINode::getFlagString", NM="_ZN4llvm6DINode13getFlagStringEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm6DINode13getFlagStringEj")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ getFlagString(/*uint*/int Flag) {
    switch (Flag) {
     default:
      return $EMPTY;
     case DIFlags.FlagPrivate:
      return $("DIFlagPrivate");
     case DIFlags.FlagProtected:
      return $("DIFlagProtected");
     case DIFlags.FlagPublic:
      return $("DIFlagPublic");
     case DIFlags.FlagFwdDecl:
      return $("DIFlagFwdDecl");
     case DIFlags.FlagAppleBlock:
      return $("DIFlagAppleBlock");
     case DIFlags.FlagBlockByrefStruct:
      return $("DIFlagBlockByrefStruct");
     case DIFlags.FlagVirtual:
      return $("DIFlagVirtual");
     case DIFlags.FlagArtificial:
      return $("DIFlagArtificial");
     case DIFlags.FlagExplicit:
      return $("DIFlagExplicit");
     case DIFlags.FlagPrototyped:
      return $("DIFlagPrototyped");
     case DIFlags.FlagObjcClassComplete:
      return $("DIFlagObjcClassComplete");
     case DIFlags.FlagObjectPointer:
      return $("DIFlagObjectPointer");
     case DIFlags.FlagVector:
      return $("DIFlagVector");
     case DIFlags.FlagStaticMember:
      return $("DIFlagStaticMember");
     case DIFlags.FlagLValueReference:
      return $("DIFlagLValueReference");
     case DIFlags.FlagRValueReference:
      return $("DIFlagRValueReference");
     case DIFlags.FlagExternalTypeRef:
      return $("DIFlagExternalTypeRef");
     case DIFlags.FlagSingleInheritance:
      return $("DIFlagSingleInheritance");
     case DIFlags.FlagMultipleInheritance:
      return $("DIFlagMultipleInheritance");
     case DIFlags.FlagVirtualInheritance:
      return $("DIFlagVirtualInheritance");
     case DIFlags.FlagIntroducedVirtual:
      return $("DIFlagIntroducedVirtual");
     case DIFlags.FlagBitField:
      return $("DIFlagBitField");
    }
  }

  
  /// \brief Split up a flags bitfield.
  ///
  /// Split \c Flags into \c SplitFlags, a vector of its components.  Returns
  /// any remaining (unrecognized) bits.
  //<editor-fold defaultstate="collapsed" desc="llvm::DINode::splitFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 86,
   FQN="llvm::DINode::splitFlags", NM="_ZN4llvm6DINode10splitFlagsEjRNS_15SmallVectorImplIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm6DINode10splitFlagsEjRNS_15SmallVectorImplIjEE")
  //</editor-fold>
  public static /*uint*/int splitFlags(/*uint*/int Flags, 
            final SmallVectorImplUInt /*&*/ SplitFlags) {
    {
      // Accessibility and member pointer flags need to be specially handled, since
      // they're packed together.
      /*uint*/int A = Flags & DIFlags.FlagAccessibility;
      if ((A != 0)) {
        if (A == DIFlags.FlagPrivate) {
          SplitFlags.push_back(DIFlags.FlagPrivate);
        } else if (A == DIFlags.FlagProtected) {
          SplitFlags.push_back(DIFlags.FlagProtected);
        } else {
          SplitFlags.push_back(DIFlags.FlagPublic);
        }
        Flags &= ~A;
      }
    }
    {
      /*uint*/int R = Flags & DIFlags.FlagPtrToMemberRep;
      if ((R != 0)) {
        if (R == DIFlags.FlagSingleInheritance) {
          SplitFlags.push_back(DIFlags.FlagSingleInheritance);
        } else if (R == DIFlags.FlagMultipleInheritance) {
          SplitFlags.push_back(DIFlags.FlagMultipleInheritance);
        } else {
          SplitFlags.push_back(DIFlags.FlagVirtualInheritance);
        }
        Flags &= ~R;
      }
    }
    {
      /*uint*/int Bit = Flags & 1;
      if ((Bit != 0)) {
        SplitFlags.push_back(Bit);
        Flags &= ~Bit;
      }
    }
    {
      /*uint*/int Bit = Flags & 2;
      if ((Bit != 0)) {
        SplitFlags.push_back(Bit);
        Flags &= ~Bit;
      }
    }
    {
      /*uint*/int Bit = Flags & 3;
      if ((Bit != 0)) {
        SplitFlags.push_back(Bit);
        Flags &= ~Bit;
      }
    }
    {
      /*uint*/int Bit = Flags & (1 << 2);
      if ((Bit != 0)) {
        SplitFlags.push_back(Bit);
        Flags &= ~Bit;
      }
    }
    {
      /*uint*/int Bit = Flags & (1 << 3);
      if ((Bit != 0)) {
        SplitFlags.push_back(Bit);
        Flags &= ~Bit;
      }
    }
    {
      /*uint*/int Bit = Flags & (1 << 4);
      if ((Bit != 0)) {
        SplitFlags.push_back(Bit);
        Flags &= ~Bit;
      }
    }
    {
      /*uint*/int Bit = Flags & (1 << 5);
      if ((Bit != 0)) {
        SplitFlags.push_back(Bit);
        Flags &= ~Bit;
      }
    }
    {
      /*uint*/int Bit = Flags & (1 << 6);
      if ((Bit != 0)) {
        SplitFlags.push_back(Bit);
        Flags &= ~Bit;
      }
    }
    {
      /*uint*/int Bit = Flags & (1 << 7);
      if ((Bit != 0)) {
        SplitFlags.push_back(Bit);
        Flags &= ~Bit;
      }
    }
    {
      /*uint*/int Bit = Flags & (1 << 8);
      if ((Bit != 0)) {
        SplitFlags.push_back(Bit);
        Flags &= ~Bit;
      }
    }
    {
      /*uint*/int Bit = Flags & (1 << 9);
      if ((Bit != 0)) {
        SplitFlags.push_back(Bit);
        Flags &= ~Bit;
      }
    }
    {
      /*uint*/int Bit = Flags & (1 << 10);
      if ((Bit != 0)) {
        SplitFlags.push_back(Bit);
        Flags &= ~Bit;
      }
    }
    {
      /*uint*/int Bit = Flags & (1 << 11);
      if ((Bit != 0)) {
        SplitFlags.push_back(Bit);
        Flags &= ~Bit;
      }
    }
    {
      /*uint*/int Bit = Flags & (1 << 12);
      if ((Bit != 0)) {
        SplitFlags.push_back(Bit);
        Flags &= ~Bit;
      }
    }
    {
      /*uint*/int Bit = Flags & (1 << 13);
      if ((Bit != 0)) {
        SplitFlags.push_back(Bit);
        Flags &= ~Bit;
      }
    }
    {
      /*uint*/int Bit = Flags & (1 << 14);
      if ((Bit != 0)) {
        SplitFlags.push_back(Bit);
        Flags &= ~Bit;
      }
    }
    {
      /*uint*/int Bit = Flags & (1 << 15);
      if ((Bit != 0)) {
        SplitFlags.push_back(Bit);
        Flags &= ~Bit;
      }
    }
    {
      /*uint*/int Bit = Flags & (1 << 16);
      if ((Bit != 0)) {
        SplitFlags.push_back(Bit);
        Flags &= ~Bit;
      }
    }
    {
      /*uint*/int Bit = Flags & (2 << 16);
      if ((Bit != 0)) {
        SplitFlags.push_back(Bit);
        Flags &= ~Bit;
      }
    }
    {
      /*uint*/int Bit = Flags & (3 << 16);
      if ((Bit != 0)) {
        SplitFlags.push_back(Bit);
        Flags &= ~Bit;
      }
    }
    {
      /*uint*/int Bit = Flags & (1 << 18);
      if ((Bit != 0)) {
        SplitFlags.push_back(Bit);
        Flags &= ~Bit;
      }
    }
    {
      /*uint*/int Bit = Flags & (1 << 19);
      if ((Bit != 0)) {
        SplitFlags.push_back(Bit);
        Flags &= ~Bit;
      }
    }
    
    return Flags;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DINode::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 192,
   FQN="llvm::DINode::classof", NM="_ZN4llvm6DINode7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm6DINode7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    switch (Metadata.MetadataKind.valueOf(MD.getMetadataID())) {
     default:
      return false;
     case GenericDINodeKind:
     case DISubrangeKind:
     case DIEnumeratorKind:
     case DIBasicTypeKind:
     case DIDerivedTypeKind:
     case DICompositeTypeKind:
     case DISubroutineTypeKind:
     case DIFileKind:
     case DICompileUnitKind:
     case DISubprogramKind:
     case DILexicalBlockKind:
     case DILexicalBlockFileKind:
     case DINamespaceKind:
     case DITemplateTypeParameterKind:
     case DITemplateValueParameterKind:
     case DIGlobalVariableKind:
     case DILocalVariableKind:
     case DIObjCPropertyKind:
     case DIImportedEntityKind:
     case DIModuleKind:
      return true;
    }
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
