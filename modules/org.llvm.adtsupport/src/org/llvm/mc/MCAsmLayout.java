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

package org.llvm.mc;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.io.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.llvm.adt.java.ADTRTTI.*;
import static org.llvm.mc.impl.MCFragmentLlvmGlobals.computeBundlePadding;
import org.llvm.mc.impl.MCFragmentStatics;
import static org.llvm.mc.stats.impl.StatsStatics.FragmentLayouts;


/// Encapsulates the layout of an assembly file at a particular point in time.
///
/// Assembly may require computing multiple layouts for a particular assembly
/// file as part of the relaxation process. This class encapsulates the layout
/// at a single point in time in such a way that it is always possible to
/// efficiently compute the exact address of any symbol in the assembly file,
/// even during the relaxation process.
//<editor-fold defaultstate="collapsed" desc="llvm::MCAsmLayout">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmLayout.h", line = 29,
 FQN="llvm::MCAsmLayout", NM="_ZN4llvm11MCAsmLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAsmLayoutE")
//</editor-fold>
public class MCAsmLayout implements Destructors.ClassWithDestructor {
  private final MCAssembler /*&*/ Assembler;
  
  /// List of sections in layout order.
  private SmallVector<MCSection /*P*/ > SectionOrder;
  
  /// The last fragment which was laid out, or 0 if nothing has been laid
  /// out. Fragments are always laid out in order, so all fragments with a
  /// lower ordinal will be valid.
  private /*mutable */DenseMap</*const*/ MCSection /*P*/ , MCFragment /*P*/ > LastValidFragment;
  
  /// \brief Make sure that the layout for the given fragment is valid, lazily
  /// computing it if necessary.
  
  /// \brief Make sure that the layout for the given fragment is valid, lazily
  /// computing it if necessary.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmLayout::ensureValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", line = 61,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", old_line = 62,
   FQN="llvm::MCAsmLayout::ensureValid", NM="_ZNK4llvm11MCAsmLayout11ensureValidEPKNS_10MCFragmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm11MCAsmLayout11ensureValidEPKNS_10MCFragmentE")
  //</editor-fold>
  private void ensureValid(/*const*/ MCFragment /*P*/ F) /*const*/ {
    MCSection /*P*/ Sec = F.getParent();
    ilist_iterator<MCFragment> I/*J*/= new ilist_iterator<MCFragment>(ilist_traitsMCFragment.$instance());
    {
      MCFragment /*P*/ Cur = LastValidFragment.$at_T1$RR(Sec);
      if ((Cur != null)) {
        I.$assign(new ilist_iterator<MCFragment>(Cur, ilist_traitsMCFragment.$instance()).$preInc());
      } else {
        I.$assignMove(Sec.begin());
      }
    }
    
    // Advance the layout position until the fragment is valid.
    while (!isFragmentValid(F)) {
      assert (I.$noteq(Sec.end())) : "Layout bookkeeping error";
      ((/*const_cast*/MCAsmLayout /*P*/ )(this)).layoutFragment($AddrOf(I.$star()));
      I.$preInc();
    }
  }


  
  /// \brief Is the layout for this fragment valid?
  
  /// \brief Is the layout for this fragment valid?
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmLayout::isFragmentValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", line = 42,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", old_line = 43,
   FQN="llvm::MCAsmLayout::isFragmentValid", NM="_ZNK4llvm11MCAsmLayout15isFragmentValidEPKNS_10MCFragmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm11MCAsmLayout15isFragmentValidEPKNS_10MCFragmentE")
  //</editor-fold>
  private boolean isFragmentValid(/*const*/ MCFragment /*P*/ F) /*const*/ {
    /*const*/ MCSection /*P*/ Sec = F.getParent();
    /*const*/ MCFragment /*P*/ LastValid = LastValidFragment.lookup(Sec);
    if (!(LastValid != null)) {
      return false;
    }
    assert (LastValid.getParent() == Sec);
    return $lesseq_uint(F.getLayoutOrder(), LastValid.getLayoutOrder());
  }


/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmLayout::MCAsmLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", line = 30,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", old_line = 31,
   FQN="llvm::MCAsmLayout::MCAsmLayout", NM="_ZN4llvm11MCAsmLayoutC1ERNS_11MCAssemblerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm11MCAsmLayoutC1ERNS_11MCAssemblerE")
  //</editor-fold>
  public MCAsmLayout(final MCAssembler /*&*/ Asm) {
    // : Assembler(Asm), SectionOrder(), LastValidFragment() 
    //START JInit
    this./*&*/Assembler=/*&*/Asm;
    this.SectionOrder = new SmallVector<MCSection /*P*/ >(16, (MCSection /*P*/ )null);
    this.LastValidFragment = new DenseMap</*const*/ MCSection /*P*/ , MCFragment /*P*/ >(DenseMapInfo$LikePtr.$Info(), (MCFragment /*P*/ )null);
    //END JInit
    // Compute the section layout order. Virtual sections must go last.
    for (final MCSection /*&*/ Sec : Asm)  {
      if (!Sec.isVirtualSection()) {
        SectionOrder.push_back($AddrOf(Sec));
      }
    }
    for (final MCSection /*&*/ Sec : Asm)  {
      if (Sec.isVirtualSection()) {
        SectionOrder.push_back($AddrOf(Sec));
      }
    }
  }


  
  /// Get the assembler object this is a layout for.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmLayout::getAssembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmLayout.h", line = 51,
   FQN="llvm::MCAsmLayout::getAssembler", NM="_ZNK4llvm11MCAsmLayout12getAssemblerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAsmLayout12getAssemblerEv")
  //</editor-fold>
  public MCAssembler /*&*/ getAssembler() /*const*/ {
    return Assembler;
  }

  
  /// \brief Invalidate the fragments starting with F because it has been
  /// resized. The fragment's size should have already been updated, but
  /// its bundle padding will be recomputed.
  
  /// \brief Invalidate the fragments starting with F because it has been
  /// resized. The fragment's size should have already been updated, but
  /// its bundle padding will be recomputed.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmLayout::invalidateFragmentsFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", line = 51,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", old_line = 52,
   FQN="llvm::MCAsmLayout::invalidateFragmentsFrom", NM="_ZN4llvm11MCAsmLayout23invalidateFragmentsFromEPNS_10MCFragmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm11MCAsmLayout23invalidateFragmentsFromEPNS_10MCFragmentE")
  //</editor-fold>
  public void invalidateFragmentsFrom(MCFragment /*P*/ F) {
    // If this fragment wasn't already valid, we don't need to do anything.
    if (!isFragmentValid(F)) {
      return;
    }
    
    // Otherwise, reset the last valid fragment to the previous fragment
    // (if this is the first fragment, it will be NULL).
    LastValidFragment.$set(F.getParent(), F.getPrevNode());
  }


  
  /// \brief Perform layout for a single fragment, assuming that the previous
  /// fragment has already been laid out correctly, and the parent section has
  /// been initialized.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmLayout::layoutFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 315,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 310,
   FQN="llvm::MCAsmLayout::layoutFragment", NM="_ZN4llvm11MCAsmLayout14layoutFragmentEPNS_10MCFragmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAsmLayout14layoutFragmentEPNS_10MCFragmentE")
  //</editor-fold>
  public void layoutFragment(MCFragment /*P*/ F) {
    MCFragment /*P*/ Prev = F.getPrevNode();
    
    // We should never try to recompute something which is valid.
    assert (!isFragmentValid(F)) : "Attempt to recompute a valid fragment!";
    // We should never try to compute the fragment layout if its predecessor
    // isn't valid.
    assert ((!(Prev != null) || isFragmentValid(Prev))) : "Attempt to compute fragment before its predecessor!";
    
    FragmentLayouts.$preInc();
    
    // Compute fragment offset and size.
    if ((Prev != null)) {
      F.Offset = Prev.Offset + getAssembler().computeFragmentSize(/*Deref*/this, $Deref(Prev));
    } else {
      F.Offset = $int2ulong(0);
    }
    LastValidFragment.$set(F.getParent(), F);
    
    // If bundling is enabled and this fragment has instructions in it, it has to
    // obey the bundling restrictions. With padding, we'll have:
    //
    //
    //        BundlePadding
    //             |||
    // -------------------------------------
    //   Prev  |##########|       F        |
    // -------------------------------------
    //                    ^
    //                    |
    //                    F->Offset
    //
    // The fragment's offset will point to after the padding, and its computed
    // size won't include the padding.
    //
    // When the -mc-relax-all flag is used, we optimize bundling by writting the
    // padding directly into fragments when the instructions are emitted inside
    // the streamer. When the fragment is larger than the bundle size, we need to
    // ensure that it's bundle aligned. This means that if we end up with
    // multiple fragments, we must emit bundle padding between fragments.
    //
    // ".align N" is an example of a directive that introduces multiple
    // fragments. We could add a special case to handle ".align N" by emitting
    // within-fragment padding (which would produce less padding when N is less
    // than the bundle size), but for now we don't.
    //
    if (Assembler.isBundlingEnabled() && F.hasInstructions()) {
      assert (isa_MCEncodedFragment(F)) : "Only MCEncodedFragment implementations have instructions";
      long/*uint64_t*/ FSize = Assembler.computeFragmentSize(/*Deref*/this, $Deref(F));
      if (!Assembler.getRelaxAll() && $greater_ulong_uint(FSize, Assembler.getBundleAlignSize())) {
        report_fatal_error($("Fragment can't be larger than a bundle size"));
      }
      
      long/*uint64_t*/ RequiredBundlePadding = computeBundlePadding(Assembler, F, 
          F.Offset, FSize);
      if ($greater_ulong_uint(RequiredBundlePadding, UINT8_MAX)) {
        report_fatal_error($("Padding cannot exceed 255 bytes"));
      }
      F.setBundlePadding(((/*static_cast*/byte/*uint8_t*/)($ulong2uchar(RequiredBundlePadding))));
      F.Offset += RequiredBundlePadding;
    }
  }

  
  /// \name Section Access (in layout order)
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmLayout::getSectionOrder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmLayout.h", line = 66,
   FQN="llvm::MCAsmLayout::getSectionOrder", NM="_ZN4llvm11MCAsmLayout15getSectionOrderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAsmLayout15getSectionOrderEv")
  //</editor-fold>
  public SmallVectorImpl<MCSection /*P*/ > /*&*/ getSectionOrder() {
    return SectionOrder;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmLayout::getSectionOrder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmLayout.h", line = 67,
   FQN="llvm::MCAsmLayout::getSectionOrder", NM="_ZNK4llvm11MCAsmLayout15getSectionOrderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm11MCAsmLayout15getSectionOrderEv")
  //</editor-fold>
  public /*const*/ SmallVectorImpl<MCSection /*P*/ > /*&*/ getSectionOrder$Const() /*const*/ {
    return SectionOrder;
  }

  
  /// @}
  /// \name Fragment Layout Data
  /// @{
  
  /// \brief Get the offset of the given fragment inside its containing section.
  
  /// @}
  /// \name Fragment Layout Data
  /// @{
  
  /// \brief Get the offset of the given fragment inside its containing section.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmLayout::getFragmentOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", line = 77,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", old_line = 78,
   FQN="llvm::MCAsmLayout::getFragmentOffset", NM="_ZNK4llvm11MCAsmLayout17getFragmentOffsetEPKNS_10MCFragmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm11MCAsmLayout17getFragmentOffsetEPKNS_10MCFragmentE")
  //</editor-fold>
  public long/*uint64_t*/ getFragmentOffset(/*const*/ MCFragment /*P*/ F) /*const*/ {
    ensureValid(F);
    assert (F.Offset != ~0L/*ULL*/) : "Address not set!";
    return F.Offset;
  }


  
  /// @}
  /// \name Utility Functions
  /// @{
  
  /// \brief Get the address space size of the given section, as it effects
  /// layout. This may differ from the size reported by \see getSectionSize() by
  /// not including section tail padding.
  
  /// @}
  /// \name Utility Functions
  /// @{
  
  /// \brief Get the address space size of the given section, as it effects
  /// layout. This may differ from the size reported by \see getSectionSize() by
  /// not including section tail padding.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmLayout::getSectionAddressSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", line = 176,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", old_line = 177,
   FQN="llvm::MCAsmLayout::getSectionAddressSize", NM="_ZNK4llvm11MCAsmLayout21getSectionAddressSizeEPKNS_9MCSectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm11MCAsmLayout21getSectionAddressSizeEPKNS_9MCSectionE")
  //</editor-fold>
  public long/*uint64_t*/ getSectionAddressSize(/*const*/ MCSection /*P*/ Sec) /*const*/ {
    // The size is the last fragment's end offset.
    final /*const*/ MCFragment /*&*/ F = Sec.getFragmentList$Const().back$Const();
    return getFragmentOffset($AddrOf(F)) + getAssembler().computeFragmentSize(/*Deref*/this, F);
  }


  
  /// \brief Get the data size of the given section, as emitted to the object
  /// file. This may include additional padding, or be 0 for virtual sections.
  
  /// \brief Get the data size of the given section, as emitted to the object
  /// file. This may include additional padding, or be 0 for virtual sections.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmLayout::getSectionFileSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", line = 182,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", old_line = 183,
   FQN="llvm::MCAsmLayout::getSectionFileSize", NM="_ZNK4llvm11MCAsmLayout18getSectionFileSizeEPKNS_9MCSectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm11MCAsmLayout18getSectionFileSizeEPKNS_9MCSectionE")
  //</editor-fold>
  public long/*uint64_t*/ getSectionFileSize(/*const*/ MCSection /*P*/ Sec) /*const*/ {
    // Virtual sections have no file size.
    if (Sec.isVirtualSection()) {
      return $int2ulong(0);
    }
    
    // Otherwise, the file size is the same as the address space size.
    return getSectionAddressSize(Sec);
  }


  
  /// \brief Get the offset of the given symbol, as computed in the current
  /// layout.
  /// \return True on success.
  
  /// \brief Get the offset of the given symbol, as computed in the current
  /// layout.
  /// \return True on success.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmLayout::getSymbolOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", line = 129,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", old_line = 130,
   FQN="llvm::MCAsmLayout::getSymbolOffset", NM="_ZNK4llvm11MCAsmLayout15getSymbolOffsetERKNS_8MCSymbolERy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm11MCAsmLayout15getSymbolOffsetERKNS_8MCSymbolERy")
  //</editor-fold>
  public boolean getSymbolOffset(final /*const*/ MCSymbol /*&*/ S, final ulong$ref/*uint64_t &*/ Val) /*const*/ {
    return MCFragmentStatics.getSymbolOffsetImpl(/*Deref*/this, S, false, Val);
  }


  
  /// \brief Variant that reports a fatal error if the offset is not computable.
  
  /// \brief Variant that reports a fatal error if the offset is not computable.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmLayout::getSymbolOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", line = 133,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", old_line = 134,
   FQN="llvm::MCAsmLayout::getSymbolOffset", NM="_ZNK4llvm11MCAsmLayout15getSymbolOffsetERKNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm11MCAsmLayout15getSymbolOffsetERKNS_8MCSymbolE")
  //</editor-fold>
  public long/*uint64_t*/ getSymbolOffset(final /*const*/ MCSymbol /*&*/ S) /*const*/ {
    ulong$ref Val = create_ulong$ref();
    MCFragmentStatics.getSymbolOffsetImpl(/*Deref*/this, S, true, Val);
    return Val.$deref();
  }


  
  /// \brief If this symbol is equivalent to A + Constant, return A.
  
  /// \brief If this symbol is equivalent to A + Constant, return A.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmLayout::getBaseSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", line = 139,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", old_line = 140,
   FQN="llvm::MCAsmLayout::getBaseSymbol", NM="_ZNK4llvm11MCAsmLayout13getBaseSymbolERKNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZNK4llvm11MCAsmLayout13getBaseSymbolERKNS_8MCSymbolE")
  //</editor-fold>
  public /*const*/ MCSymbol /*P*/ getBaseSymbol(final /*const*/ MCSymbol /*&*/ Symbol) /*const*/ {
    if (!Symbol.isVariable()) {
      return $AddrOf(Symbol);
    }
    
    /*const*/ MCExpr /*P*/ Expr = Symbol.getVariableValue();
    MCValue Value/*J*/= new MCValue();
    if (!Expr.evaluateAsValue(Value, /*Deref*/this)) {
      Assembler.getContext().reportError(new SMLoc(), new Twine(/*KEEP_STR*/"expression could not be evaluated"));
      return null;
    }
    
    /*const*/ MCSymbolRefExpr /*P*/ RefB = Value.getSymB();
    if ((RefB != null)) {
      Assembler.getContext().reportError(new SMLoc(), $add_Twine$C($add_Twine$C(new Twine(/*KEEP_STR*/"symbol '"), new Twine(RefB.getSymbol().getName())), 
              new Twine(/*KEEP_STR*/"' could not be evaluated in a subtraction expression")));
      return null;
    }
    
    /*const*/ MCSymbolRefExpr /*P*/ A = Value.getSymA();
    if (!(A != null)) {
      return null;
    }
    
    final /*const*/ MCSymbol /*&*/ ASym = A.getSymbol();
    final /*const*/ MCAssembler /*&*/ Asm = getAssembler();
    if (ASym.isCommon()) {
      // FIXME: we should probably add a SMLoc to MCExpr.
      Asm.getContext().reportError(new SMLoc(), 
          $add_Twine$C($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"Common symbol '", ASym.getName()), 
              new Twine(/*KEEP_STR*/"' cannot be used in assignment expr")));
      return null;
    }
    
    return $AddrOf(ASym);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmLayout::~MCAsmLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmLayout.h", line = 29,
   FQN="llvm::MCAsmLayout::~MCAsmLayout", NM="_ZN4llvm11MCAsmLayoutD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm11MCAsmLayoutD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    LastValidFragment.$destroy();
    SectionOrder.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Assembler=" + Assembler // NOI18N
              + ", SectionOrder=" + SectionOrder // NOI18N
              + ", LastValidFragment=" + LastValidFragment; // NOI18N
  }
/// @}
}
