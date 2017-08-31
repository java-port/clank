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

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;


/// \brief Base class for types.
///
/// TODO: Remove the hardcoded name and context, since many types don't use
/// them.
/// TODO: Split up flags.
//<editor-fold defaultstate="collapsed" desc="llvm::DIType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 509,
 FQN="llvm::DIType", NM="_ZN4llvm6DITypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm6DITypeE")
//</editor-fold>
public class DIType extends /*public*/ DIScope implements Destructors.ClassWithDestructor {
  private /*uint*/int Line;
  private /*uint*/int Flags;
  private long/*uint64_t*/ SizeInBits;
  private long/*uint64_t*/ AlignInBits;
  private long/*uint64_t*/ OffsetInBits;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::DIType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 517,
   FQN="llvm::DIType::DIType", NM="_ZN4llvm6DITypeC1ERNS_11LLVMContextEjNS_8Metadata11StorageTypeEjjyyyjNS_8ArrayRefIPS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm6DITypeC1ERNS_11LLVMContextEjNS_8Metadata11StorageTypeEjjyyyjNS_8ArrayRefIPS3_EE")
  //</editor-fold>
  protected DIType(final LLVMContext /*&*/ C, /*uint*/int ID, Metadata.StorageType Storage, /*uint*/int Tag,
      /*uint*/int Line, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits,
      long/*uint64_t*/ OffsetInBits, /*uint*/int Flags, ArrayRef<Metadata /*P*/ > Ops) {
    // : DIScope(C, ID, Storage, Tag, Ops)
    //START JInit
    super(C, ID, Storage, Tag, new ArrayRef<Metadata /*P*/ >(Ops));
    //END JInit
    init(Line, SizeInBits, AlignInBits, OffsetInBits, Flags);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::~DIType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 523,
   FQN="llvm::DIType::~DIType", NM="_ZN4llvm6DITypeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm6DITypeD0Ev")
  //</editor-fold>
  public/*protected*/ void $destroy()/* = default*/ {
    super.$destroy();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::init">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 525,
   FQN="llvm::DIType::init", NM="_ZN4llvm6DIType4initEjyyyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm6DIType4initEjyyyj")
  //</editor-fold>
  protected void init(/*uint*/int Line, long/*uint64_t*/ SizeInBits, long/*uint64_t*/ AlignInBits,
      long/*uint64_t*/ OffsetInBits, /*uint*/int Flags) {
    this.Line = Line;
    this.Flags = Flags;
    this.SizeInBits = SizeInBits;
    this.AlignInBits = AlignInBits;
    this.OffsetInBits = OffsetInBits;
  }


  /// Change fields in place.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::mutate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 535,
   FQN="llvm::DIType::mutate", NM="_ZN4llvm6DIType6mutateEjjyyyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm6DIType6mutateEjjyyyj")
  //</editor-fold>
  protected void mutate(/*uint*/int Tag, /*uint*/int Line, long/*uint64_t*/ SizeInBits,
        long/*uint64_t*/ AlignInBits, long/*uint64_t*/ OffsetInBits, /*uint*/int Flags) {
    assert (isDistinct()) : "Only distinct nodes can mutate";
    setTag(Tag);
    init(Line, SizeInBits, AlignInBits, OffsetInBits, Flags);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::clone">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 543,
   FQN="llvm::DIType::clone", NM="_ZNK4llvm6DIType5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIType5cloneEv")
  //</editor-fold>
  public std.unique_ptr_with_deleter<? extends DIType /*, TempMDNodeDeleter*/> clone() /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(new std.unique_ptr_with_deleter<DIType /*, TempMDNodeDeleter*/>(cast_DIType($c$.track(super.clone()).release())));
    } finally {
      $c$.$destroy();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::getLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 547,
   FQN="llvm::DIType::getLine", NM="_ZNK4llvm6DIType7getLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIType7getLineEv")
  //</editor-fold>
  public /*uint*/int getLine() /*const*/ {
    return Line;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::getSizeInBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 548,
   FQN="llvm::DIType::getSizeInBits", NM="_ZNK4llvm6DIType13getSizeInBitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIType13getSizeInBitsEv")
  //</editor-fold>
  public long/*uint64_t*/ getSizeInBits() /*const*/ {
    return SizeInBits;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::getAlignInBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 549,
   FQN="llvm::DIType::getAlignInBits", NM="_ZNK4llvm6DIType14getAlignInBitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIType14getAlignInBitsEv")
  //</editor-fold>
  public long/*uint64_t*/ getAlignInBits() /*const*/ {
    return AlignInBits;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::getOffsetInBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 550,
   FQN="llvm::DIType::getOffsetInBits", NM="_ZNK4llvm6DIType15getOffsetInBitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIType15getOffsetInBitsEv")
  //</editor-fold>
  public long/*uint64_t*/ getOffsetInBits() /*const*/ {
    return OffsetInBits;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::getFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 551,
   FQN="llvm::DIType::getFlags", NM="_ZNK4llvm6DIType8getFlagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIType8getFlagsEv")
  //</editor-fold>
  public /*uint*/int getFlags() /*const*/ {
    return Flags;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::getScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 553,
   FQN="llvm::DIType::getScope", NM="_ZNK4llvm6DIType8getScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIType8getScopeEv")
  //</editor-fold>
  public TypedDINodeRef<DIScope> getScope() /*const*/ {
    return new TypedDINodeRef<DIScope>(DIScope.class, getRawScope());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 554,
   FQN="llvm::DIType::getName", NM="_ZNK4llvm6DIType7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIType7getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    return getStringOperand(2);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::getRawScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 557,
   FQN="llvm::DIType::getRawScope", NM="_ZNK4llvm6DIType11getRawScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIType11getRawScopeEv")
  //</editor-fold>
  public Metadata /*P*/ getRawScope() /*const*/ {
    return getOperand(1).$Metadata$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::getRawName">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 558,
   FQN="llvm::DIType::getRawName", NM="_ZNK4llvm6DIType10getRawNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIType10getRawNameEv")
  //</editor-fold>
  public MDString /*P*/ getRawName() /*const*/ {
    return this.<MDString>getOperandAs(MDString.class, 2);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::setFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 560,
   FQN="llvm::DIType::setFlags", NM="_ZN4llvm6DIType8setFlagsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm6DIType8setFlagsEj")
  //</editor-fold>
  public void setFlags(/*uint*/int NewFlags) {
    assert (!isUniqued()) : "Cannot set flags on uniqued nodes";
    Flags = NewFlags;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::isPrivate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 565,
   FQN="llvm::DIType::isPrivate", NM="_ZNK4llvm6DIType9isPrivateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIType9isPrivateEv")
  //</editor-fold>
  public boolean isPrivate() /*const*/ {
    return (getFlags() & DIFlags.FlagAccessibility) == DIFlags.FlagPrivate;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::isProtected">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 568,
   FQN="llvm::DIType::isProtected", NM="_ZNK4llvm6DIType11isProtectedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIType11isProtectedEv")
  //</editor-fold>
  public boolean isProtected() /*const*/ {
    return (getFlags() & DIFlags.FlagAccessibility) == DIFlags.FlagProtected;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::isPublic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 571,
   FQN="llvm::DIType::isPublic", NM="_ZNK4llvm6DIType8isPublicEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIType8isPublicEv")
  //</editor-fold>
  public boolean isPublic() /*const*/ {
    return (getFlags() & DIFlags.FlagAccessibility) == DIFlags.FlagPublic;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::isForwardDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 574,
   FQN="llvm::DIType::isForwardDecl", NM="_ZNK4llvm6DIType13isForwardDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIType13isForwardDeclEv")
  //</editor-fold>
  public boolean isForwardDecl() /*const*/ {
    return ((getFlags() & DIFlags.FlagFwdDecl) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::isAppleBlockExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 575,
   FQN="llvm::DIType::isAppleBlockExtension", NM="_ZNK4llvm6DIType21isAppleBlockExtensionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIType21isAppleBlockExtensionEv")
  //</editor-fold>
  public boolean isAppleBlockExtension() /*const*/ {
    return ((getFlags() & DIFlags.FlagAppleBlock) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::isBlockByrefStruct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 576,
   FQN="llvm::DIType::isBlockByrefStruct", NM="_ZNK4llvm6DIType18isBlockByrefStructEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIType18isBlockByrefStructEv")
  //</editor-fold>
  public boolean isBlockByrefStruct() /*const*/ {
    return ((getFlags() & DIFlags.FlagBlockByrefStruct) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::isVirtual">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 577,
   FQN="llvm::DIType::isVirtual", NM="_ZNK4llvm6DIType9isVirtualEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIType9isVirtualEv")
  //</editor-fold>
  public boolean isVirtual() /*const*/ {
    return ((getFlags() & DIFlags.FlagVirtual) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::isArtificial">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 578,
   FQN="llvm::DIType::isArtificial", NM="_ZNK4llvm6DIType12isArtificialEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIType12isArtificialEv")
  //</editor-fold>
  public boolean isArtificial() /*const*/ {
    return ((getFlags() & DIFlags.FlagArtificial) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::isObjectPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 579,
   FQN="llvm::DIType::isObjectPointer", NM="_ZNK4llvm6DIType15isObjectPointerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIType15isObjectPointerEv")
  //</editor-fold>
  public boolean isObjectPointer() /*const*/ {
    return ((getFlags() & DIFlags.FlagObjectPointer) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::isObjcClassComplete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 580,
   FQN="llvm::DIType::isObjcClassComplete", NM="_ZNK4llvm6DIType19isObjcClassCompleteEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIType19isObjcClassCompleteEv")
  //</editor-fold>
  public boolean isObjcClassComplete() /*const*/ {
    return ((getFlags() & DIFlags.FlagObjcClassComplete) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::isVector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 583,
   FQN="llvm::DIType::isVector", NM="_ZNK4llvm6DIType8isVectorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIType8isVectorEv")
  //</editor-fold>
  public boolean isVector() /*const*/ {
    return ((getFlags() & DIFlags.FlagVector) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::isBitField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 584,
   FQN="llvm::DIType::isBitField", NM="_ZNK4llvm6DIType10isBitFieldEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIType10isBitFieldEv")
  //</editor-fold>
  public boolean isBitField() /*const*/ {
    return ((getFlags() & DIFlags.FlagBitField) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::isStaticMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 585,
   FQN="llvm::DIType::isStaticMember", NM="_ZNK4llvm6DIType14isStaticMemberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIType14isStaticMemberEv")
  //</editor-fold>
  public boolean isStaticMember() /*const*/ {
    return ((getFlags() & DIFlags.FlagStaticMember) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::isLValueReference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 586,
   FQN="llvm::DIType::isLValueReference", NM="_ZNK4llvm6DIType17isLValueReferenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIType17isLValueReferenceEv")
  //</editor-fold>
  public boolean isLValueReference() /*const*/ {
    return ((getFlags() & DIFlags.FlagLValueReference) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::isRValueReference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 587,
   FQN="llvm::DIType::isRValueReference", NM="_ZNK4llvm6DIType17isRValueReferenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIType17isRValueReferenceEv")
  //</editor-fold>
  public boolean isRValueReference() /*const*/ {
    return ((getFlags() & DIFlags.FlagRValueReference) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::isExternalTypeRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 588,
   FQN="llvm::DIType::isExternalTypeRef", NM="_ZNK4llvm6DIType17isExternalTypeRefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm6DIType17isExternalTypeRefEv")
  //</editor-fold>
  public boolean isExternalTypeRef() /*const*/ {
    return ((getFlags() & DIFlags.FlagExternalTypeRef) != 0);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 590,
   FQN="llvm::DIType::classof", NM="_ZN4llvm6DIType7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm6DIType7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    switch (Metadata.MetadataKind.valueOf(MD.getMetadataID())) {
     default:
      return false;
     case DIBasicTypeKind:
     case DIDerivedTypeKind:
     case DICompositeTypeKind:
     case DISubroutineTypeKind:
      return true;
    }
  }


  @Override public String toString() {
    return "" + "Line=" + Line // NOI18N
              + ", Flags=" + Flags // NOI18N
              + ", SizeInBits=" + SizeInBits // NOI18N
              + ", AlignInBits=" + AlignInBits // NOI18N
              + ", OffsetInBits=" + OffsetInBits // NOI18N
              + super.toString(); // NOI18N
  }
}
