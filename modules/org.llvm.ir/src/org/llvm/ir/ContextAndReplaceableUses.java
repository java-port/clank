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
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.adt.ADTFunctionPointers.*;
import org.llvm.llvmc.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IRFunctionPointers.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.cl.*;
import org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.ir.java.IRMemberPointers.*;
import org.llvm.ir.java.*;
import org.llvm.pass.*;
import org.llvm.support.dwarf.Tag;
import org.llvm.support.sys.SmartRWMutex;
import org.llvm.ir.java.cst_pred_ty_Predicate;
import org.llvm.ir.legacy.PassManagerBase;
import org.llvm.ir.PassManagerGlobals.*;
import org.llvm.ir.java.MDNodeKeyImpl;
import static org.llvm.adt.HashingGlobals.*;


/// \brief Pointer to the context, with optional RAUW support.
///
/// Either a raw (non-null) pointer to the \a LLVMContext, or an owned pointer
/// to \a ReplaceableMetadataImpl (which has a reference to \a LLVMContext).
//<editor-fold defaultstate="collapsed" desc="llvm::ContextAndReplaceableUses">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 715,
 FQN="llvm::ContextAndReplaceableUses", NM="_ZN4llvm25ContextAndReplaceableUsesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm25ContextAndReplaceableUsesE")
//</editor-fold>
public class ContextAndReplaceableUses implements Destructors.ClassWithDestructor {
  private PointerUnion<LLVMContext /*P*/ , ReplaceableMetadataImpl /*P*/ > Ptr;

  //<editor-fold defaultstate="collapsed" desc="llvm::ContextAndReplaceableUses::ContextAndReplaceableUses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 718,
   FQN="llvm::ContextAndReplaceableUses::ContextAndReplaceableUses", NM="_ZN4llvm25ContextAndReplaceableUsesC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm25ContextAndReplaceableUsesC1Ev")
  //</editor-fold>
  protected/*private*/ ContextAndReplaceableUses() { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::ContextAndReplaceableUses::ContextAndReplaceableUses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 719,
   FQN="llvm::ContextAndReplaceableUses::ContextAndReplaceableUses", NM="_ZN4llvm25ContextAndReplaceableUsesC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm25ContextAndReplaceableUsesC1EOS0_")
  //</editor-fold>
  protected/*private*/ ContextAndReplaceableUses(JD$Move _dparam, final ContextAndReplaceableUses /*&&*/$Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::ContextAndReplaceableUses::ContextAndReplaceableUses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 720,
   FQN="llvm::ContextAndReplaceableUses::ContextAndReplaceableUses", NM="_ZN4llvm25ContextAndReplaceableUsesC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm25ContextAndReplaceableUsesC1ERKS0_")
  //</editor-fold>
  protected/*private*/ ContextAndReplaceableUses(final /*const*/ ContextAndReplaceableUses /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::ContextAndReplaceableUses::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 721,
   FQN="llvm::ContextAndReplaceableUses::operator=", NM="_ZN4llvm25ContextAndReplaceableUsesaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm25ContextAndReplaceableUsesaSEOS0_")
  //</editor-fold>
  protected/*private*/ ContextAndReplaceableUses /*&*/ $assignMove(final ContextAndReplaceableUses /*&&*/$Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::ContextAndReplaceableUses::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 722,
   FQN="llvm::ContextAndReplaceableUses::operator=", NM="_ZN4llvm25ContextAndReplaceableUsesaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm25ContextAndReplaceableUsesaSERKS0_")
  //</editor-fold>
  protected/*private*/ ContextAndReplaceableUses /*&*/ $assign(final /*const*/ ContextAndReplaceableUses /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ContextAndReplaceableUses::ContextAndReplaceableUses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 726,
   FQN="llvm::ContextAndReplaceableUses::ContextAndReplaceableUses", NM="_ZN4llvm25ContextAndReplaceableUsesC1ERNS_11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm25ContextAndReplaceableUsesC1ERNS_11LLVMContextE")
  //</editor-fold>
  public ContextAndReplaceableUses(final LLVMContext /*&*/ Context) {
    // : Ptr(&Context)
    //START JInit
    this.Ptr = new PointerUnion<LLVMContext /*P*/ , ReplaceableMetadataImpl /*P*/ >(JD$T.INSTANCE, LLVMContext /*P*/.class, $AddrOf(Context));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ContextAndReplaceableUses::ContextAndReplaceableUses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 727,
   FQN="llvm::ContextAndReplaceableUses::ContextAndReplaceableUses", NM="_ZN4llvm25ContextAndReplaceableUsesC1ESt10unique_ptrINS_23ReplaceableMetadataImplESt14default_deleteIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm25ContextAndReplaceableUsesC1ESt10unique_ptrINS_23ReplaceableMetadataImplESt14default_deleteIS2_EE")
  //</editor-fold>
  public ContextAndReplaceableUses(std.unique_ptr<ReplaceableMetadataImpl> ReplaceableUses) {
    // : Ptr(ReplaceableUses.release())
    //START JInit
    this.Ptr = new PointerUnion<LLVMContext /*P*/ , ReplaceableMetadataImpl /*P*/ >(JD$T1.INSTANCE, ReplaceableMetadataImpl /*P*/.class, ReplaceableUses.release());
    //END JInit
    assert ((getReplaceableUses() != null)) : "Expected non-null replaceable uses";
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ContextAndReplaceableUses::~ContextAndReplaceableUses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 732,
   FQN="llvm::ContextAndReplaceableUses::~ContextAndReplaceableUses", NM="_ZN4llvm25ContextAndReplaceableUsesD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm25ContextAndReplaceableUsesD0Ev")
  //</editor-fold>
  public void $destroy() {
    /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)getReplaceableUses());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ContextAndReplaceableUses::operator LLVMContext & ">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 734,
   FQN="llvm::ContextAndReplaceableUses::operator LLVMContext & ", NM="_ZN4llvm25ContextAndReplaceableUsescvRNS_11LLVMContextEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm25ContextAndReplaceableUsescvRNS_11LLVMContextEEv")
  //</editor-fold>
  public LLVMContext /*&*/ $LLVMContext() {
    return getContext();
  }


  /// \brief Whether this contains RAUW support.
  //<editor-fold defaultstate="collapsed" desc="llvm::ContextAndReplaceableUses::hasReplaceableUses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 737,
   FQN="llvm::ContextAndReplaceableUses::hasReplaceableUses", NM="_ZNK4llvm25ContextAndReplaceableUses18hasReplaceableUsesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm25ContextAndReplaceableUses18hasReplaceableUsesEv")
  //</editor-fold>
  public boolean hasReplaceableUses() /*const*/ {
    return (Ptr.is(ReplaceableMetadataImpl /*P*/.class) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ContextAndReplaceableUses::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 740,
   FQN="llvm::ContextAndReplaceableUses::getContext", NM="_ZNK4llvm25ContextAndReplaceableUses10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm25ContextAndReplaceableUses10getContextEv")
  //</editor-fold>
  public LLVMContext /*&*/ getContext() /*const*/ {
    if (hasReplaceableUses()) {
      return getReplaceableUses().getContext();
    }
    return $Deref(Ptr.get(LLVMContext /*P*/.class));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ContextAndReplaceableUses::getReplaceableUses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 745,
   FQN="llvm::ContextAndReplaceableUses::getReplaceableUses", NM="_ZNK4llvm25ContextAndReplaceableUses18getReplaceableUsesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm25ContextAndReplaceableUses18getReplaceableUsesEv")
  //</editor-fold>
  public ReplaceableMetadataImpl /*P*/ getReplaceableUses() /*const*/ {
    if (hasReplaceableUses()) {
      return Ptr.get(ReplaceableMetadataImpl /*P*/.class);
    }
    return null;
  }


  /// Ensure that this has RAUW support, and then return it.
  //<editor-fold defaultstate="collapsed" desc="llvm::ContextAndReplaceableUses::getOrCreateReplaceableUses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 752,
   FQN="llvm::ContextAndReplaceableUses::getOrCreateReplaceableUses", NM="_ZN4llvm25ContextAndReplaceableUses26getOrCreateReplaceableUsesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm25ContextAndReplaceableUses26getOrCreateReplaceableUsesEv")
  //</editor-fold>
  public ReplaceableMetadataImpl /*P*/ getOrCreateReplaceableUses() {
    if (!hasReplaceableUses()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        class ReplaceableMetadataImplImpl  implements ReplaceableMetadataImpl {
          private final ReplaceableMetadataImpl.ReplaceableMetadataImpl$Fields $Flds;
          public ReplaceableMetadataImplImpl(LLVMContext Context) {
            $Flds = new ReplaceableMetadataImpl$Fields(Context);
          }
          @Override
          public ReplaceableMetadataImpl$Fields $ReplaceableMetadataImpl$Fields() {
            return $Flds;
          }
          @Override
          public void $destroy() {
          }
        };
        makeReplaceable($c$.track(llvm.make_unique(new ReplaceableMetadataImplImpl(getContext())))); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }
    return getReplaceableUses();
  }


  /// \brief Assign RAUW support to this.
  ///
  /// Make this replaceable, taking ownership of \c ReplaceableUses (which must
  /// not be null).
  //<editor-fold defaultstate="collapsed" desc="llvm::ContextAndReplaceableUses::makeReplaceable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 762,
   FQN="llvm::ContextAndReplaceableUses::makeReplaceable", NM="_ZN4llvm25ContextAndReplaceableUses15makeReplaceableESt10unique_ptrINS_23ReplaceableMetadataImplESt14default_deleteIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm25ContextAndReplaceableUses15makeReplaceableESt10unique_ptrINS_23ReplaceableMetadataImplESt14default_deleteIS2_EE")
  //</editor-fold>
  public void makeReplaceable(std.unique_ptr<ReplaceableMetadataImpl> ReplaceableUses) {
    assert (ReplaceableUses.$bool()) : "Expected non-null replaceable uses";
    assert ($AddrOf(ReplaceableUses.$arrow().getContext()) == $AddrOf(getContext())) : "Expected same context";
    /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)getReplaceableUses());
    Ptr.$assign_T1$C$R(ReplaceableMetadataImpl /*P*/ /*const*/ /*&*/.class, ReplaceableUses.release());
  }


  /// \brief Drop RAUW support.
  ///
  /// Cede ownership of RAUW support, returning it.
  //<editor-fold defaultstate="collapsed" desc="llvm::ContextAndReplaceableUses::takeReplaceableUses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 774,
   FQN="llvm::ContextAndReplaceableUses::takeReplaceableUses", NM="_ZN4llvm25ContextAndReplaceableUses19takeReplaceableUsesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm25ContextAndReplaceableUses19takeReplaceableUsesEv")
  //</editor-fold>
  public std.unique_ptr<ReplaceableMetadataImpl> takeReplaceableUses() {
    std.unique_ptr<ReplaceableMetadataImpl> ReplaceableUses = null;
    try {
      assert (hasReplaceableUses()) : "Expected to own replaceable uses";
      ReplaceableUses/*J*/= new std.unique_ptr<ReplaceableMetadataImpl>(getReplaceableUses());
      Ptr.$assign_T$C$R(LLVMContext /*P*/ /*const*/ /*&*/.class, $AddrOf(ReplaceableUses.$arrow().getContext()));
      return new std.unique_ptr<ReplaceableMetadataImpl>(JD$Move.INSTANCE, ReplaceableUses);
    } finally {
      if (ReplaceableUses != null) { ReplaceableUses.$destroy(); }
    }
  }


  @Override public String toString() {
    return "" + "Ptr=" + Ptr; // NOI18N
  }
}
