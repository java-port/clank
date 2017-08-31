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
import org.llvm.adt.aliases.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import static org.llvm.ir.java.IrRTTI.*;


/// \brief Value wrapper in the Metadata hierarchy.
///
/// This is a custom value handle that allows other metadata to refer to
/// classes in the Value hierarchy.
///
/// Because of full uniquing support, each value is only wrapped by a single \a
/// ValueAsMetadata object, so the lookup maps are far more efficient than
/// those using ValueHandleBase.
//<editor-fold defaultstate="collapsed" desc="llvm::ValueAsMetadata">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 312,
 FQN="llvm::ValueAsMetadata", NM="_ZN4llvm15ValueAsMetadataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15ValueAsMetadataE")
//</editor-fold>
public class ValueAsMetadata extends /*public*/ Metadata implements ReplaceableMetadataImpl, Destructors.ClassWithDestructor {
  /*friend  class ReplaceableMetadataImpl*/
  /*friend  class LLVMContextImpl*/
  
  private Value /*P*/ V;
  
  /// \brief Drop users without RAUW (during teardown).
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueAsMetadata::dropUsers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 319,
   FQN="llvm::ValueAsMetadata::dropUsers", NM="_ZN4llvm15ValueAsMetadata9dropUsersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15ValueAsMetadata9dropUsersEv")
  //</editor-fold>
  /*friend*/public/*private*/ void dropUsers() {
    ReplaceableMetadataImpl.super.resolveAllUses(/* ResolveUsers */ false);
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueAsMetadata::ValueAsMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 324,
   FQN="llvm::ValueAsMetadata::ValueAsMetadata", NM="_ZN4llvm15ValueAsMetadataC1EjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15ValueAsMetadataC1EjPNS_5ValueE")
  //</editor-fold>
  protected ValueAsMetadata(/*uint*/int ID, Value /*P*/ V) {
    // : Metadata(ID, Uniqued), ReplaceableMetadataImpl(V->getContext()), V(V) 
    //START JInit
    super(ID, StorageType.Uniqued);
    this.ReplaceableMetadataImpl$Flds = $ReplaceableMetadataImpl(V.getContext());
    this.V = V;
    //END JInit
    assert ((V != null)) : "Expected valid value";
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueAsMetadata::~ValueAsMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 328,
   FQN="llvm::ValueAsMetadata::~ValueAsMetadata", NM="_ZN4llvm15ValueAsMetadataD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15ValueAsMetadataD0Ev")
  //</editor-fold>
  public/*protected*/ void $destroy()/* = default*/ {
    super.$destroy();
    ReplaceableMetadataImpl.super.$destroy$ReplaceableMetadataImpl();
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueAsMetadata::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 308,
   FQN="llvm::ValueAsMetadata::get", NM="_ZN4llvm15ValueAsMetadata3getEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15ValueAsMetadata3getEPNS_5ValueE")
  //</editor-fold>
  public static ValueAsMetadata /*P*/ get(Value /*P*/ V) {
    assert ((V != null)) : "Unexpected null Value";
    
    final LLVMContext /*&*/ Context = V.getContext();
    final type$ref<ValueAsMetadata /*P*/ /*&*/> Entry = Context.pImpl.ValuesAsMetadata.ref$at(V);
    if (!(Entry.$deref() != null)) {
      assert ((isa_Constant(V) || isa_Argument(V) || isa_Instruction(V))) : "Expected constant or function-local value";
      assert (!V.IsUsedByMD) : "Expected this to be the only metadata use";
      V.IsUsedByMD = true;
      {
        Constant /*P*/ C = dyn_cast_Constant(V);
        if ((C != null)) {
          Entry.$set(new ConstantAsMetadata(C));
        } else {
          Entry.$set(new LocalAsMetadata(V));
        }
      }
    }
    
    return Entry.$deref();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueAsMetadata::getConstant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 332,
   FQN="llvm::ValueAsMetadata::getConstant", NM="_ZN4llvm15ValueAsMetadata11getConstantEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15ValueAsMetadata11getConstantEPNS_5ValueE")
  //</editor-fold>
  public static ConstantAsMetadata /*P*/ getConstant(Value /*P*/ C) {
    return cast_ConstantAsMetadata(get(C));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueAsMetadata::getLocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 335,
   FQN="llvm::ValueAsMetadata::getLocal", NM="_ZN4llvm15ValueAsMetadata8getLocalEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15ValueAsMetadata8getLocalEPNS_5ValueE")
  //</editor-fold>
  public static LocalAsMetadata /*P*/ getLocal(Value /*P*/ Local) {
    return cast_LocalAsMetadata(get(Local));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueAsMetadata::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 328,
   FQN="llvm::ValueAsMetadata::getIfExists", NM="_ZN4llvm15ValueAsMetadata11getIfExistsEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15ValueAsMetadata11getIfExistsEPNS_5ValueE")
  //</editor-fold>
  public static ValueAsMetadata /*P*/ getIfExists(Value /*P*/ V) {
    assert ((V != null)) : "Unexpected null Value";
    return V.getContext().pImpl.ValuesAsMetadata.lookup(V);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueAsMetadata::getConstantIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 340,
   FQN="llvm::ValueAsMetadata::getConstantIfExists", NM="_ZN4llvm15ValueAsMetadata19getConstantIfExistsEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15ValueAsMetadata19getConstantIfExistsEPNS_5ValueE")
  //</editor-fold>
  public static ConstantAsMetadata /*P*/ getConstantIfExists(Value /*P*/ C) {
    return cast_or_null_ConstantAsMetadata(getIfExists(C));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueAsMetadata::getLocalIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 343,
   FQN="llvm::ValueAsMetadata::getLocalIfExists", NM="_ZN4llvm15ValueAsMetadata16getLocalIfExistsEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15ValueAsMetadata16getLocalIfExistsEPNS_5ValueE")
  //</editor-fold>
  public static LocalAsMetadata /*P*/ getLocalIfExists(Value /*P*/ Local) {
    return cast_or_null_LocalAsMetadata(getIfExists(Local));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueAsMetadata::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 347,
   FQN="llvm::ValueAsMetadata::getValue", NM="_ZNK4llvm15ValueAsMetadata8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm15ValueAsMetadata8getValueEv")
  //</editor-fold>
  public Value /*P*/ getValue() /*const*/ {
    return V;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueAsMetadata::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 348,
   FQN="llvm::ValueAsMetadata::getType", NM="_ZNK4llvm15ValueAsMetadata7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm15ValueAsMetadata7getTypeEv")
  //</editor-fold>
  public Type /*P*/ getType() /*const*/ {
    return V.getType();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueAsMetadata::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 349,
   FQN="llvm::ValueAsMetadata::getContext", NM="_ZNK4llvm15ValueAsMetadata10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm15ValueAsMetadata10getContextEv")
  //</editor-fold>
  public LLVMContext /*&*/ getContext() /*const*/ {
    return V.getContext();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueAsMetadata::handleDeletion">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 333,
   FQN="llvm::ValueAsMetadata::handleDeletion", NM="_ZN4llvm15ValueAsMetadata14handleDeletionEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15ValueAsMetadata14handleDeletionEPNS_5ValueE")
  //</editor-fold>
  public static void handleDeletion(Value /*P*/ V) {
    assert ((V != null)) : "Expected valid value";
    
    final DenseMap<Value /*P*/ , ValueAsMetadata /*P*/> /*&*/ Store = V.getType().getContext().pImpl.ValuesAsMetadata;
    DenseMapIterator<Value /*P*/ , ValueAsMetadata /*P*/ > I = Store.find(V);
    if (I.$eq(/*NO_ITER_COPY*/Store.end())) {
      return;
    }
    
    // Remove old entry from the map.
    ValueAsMetadata /*P*/ MD = I.$arrow().second;
    assert ((MD != null)) : "Expected valid metadata";
    assert (MD.getValue() == V) : "Expected valid mapping";
    Store.erase(new DenseMapIterator<Value /*P*/ , ValueAsMetadata /*P*/ >(I));
    
    // Delete the metadata.
    MD.replaceAllUsesWith((Metadata /*P*/ )null);
    /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)MD);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueAsMetadata::handleRAUW">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 352,
   FQN="llvm::ValueAsMetadata::handleRAUW", NM="_ZN4llvm15ValueAsMetadata10handleRAUWEPNS_5ValueES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15ValueAsMetadata10handleRAUWEPNS_5ValueES2_")
  //</editor-fold>
  public static void handleRAUW(Value /*P*/ From, Value /*P*/ To) {
    assert ((From != null)) : "Expected valid value";
    assert ((To != null)) : "Expected valid value";
    assert (From != To) : "Expected changed value";
    assert (From.getType() == To.getType()) : "Unexpected type change";
    
    final LLVMContext /*&*/ Context = From.getType().getContext();
    final DenseMap<Value /*P*/ , ValueAsMetadata /*P*/> /*&*/ Store = Context.pImpl.ValuesAsMetadata;
    DenseMapIterator<Value /*P*/ , ValueAsMetadata /*P*/ > I = Store.find(From);
    if (I.$eq(/*NO_ITER_COPY*/Store.end())) {
      assert (!From.IsUsedByMD) : "Expected From not to be used by metadata";
      return;
    }
    
    // Remove old entry from the map.
    assert (From.IsUsedByMD) : "Expected From to be used by metadata";
    From.IsUsedByMD = false;
    ValueAsMetadata /*P*/ MD = I.$arrow().second;
    assert ((MD != null)) : "Expected valid metadata";
    assert (MD.getValue() == From) : "Expected valid mapping";
    Store.erase(new DenseMapIterator<Value /*P*/ , ValueAsMetadata /*P*/ >(I));
    if (isa_LocalAsMetadata(MD)) {
      {
        Constant /*P*/ C = dyn_cast_Constant(To);
        if ((C != null)) {
          // Local became a constant.
          MD.replaceAllUsesWith(ConstantAsMetadata.get(C));
          /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)MD);
          return;
        }
      }
      if ((MetadataStatics.getLocalFunction(From) != null) && (MetadataStatics.getLocalFunction(To) != null)
         && MetadataStatics.getLocalFunction(From) != MetadataStatics.getLocalFunction(To)) {
        // Function changed.
        MD.replaceAllUsesWith((Metadata /*P*/ )null);
        /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)MD);
        return;
      }
    } else if (!isa_Constant(To)) {
      // Changed to function-local value.
      MD.replaceAllUsesWith((Metadata /*P*/ )null);
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)MD);
      return;
    }
    
    final type$ref<ValueAsMetadata /*P*/ /*&*/> Entry = Store.ref$at(To);
    if ((Entry.$deref() != null)) {
      // The target already exists.
      MD.replaceAllUsesWith(Entry.$deref());
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)MD);
      return;
    }
    
    // Update MD in place (and update the map entry).
    assert (!To.IsUsedByMD) : "Expected this to be the only metadata use";
    To.IsUsedByMD = true;
    MD.V = To;
    Entry.$set(MD);
  }

/*protected:*/
  /// \brief Handle collisions after \a Value::replaceAllUsesWith().
  ///
  /// RAUW isn't supported directly for \a ValueAsMetadata, but if the wrapped
  /// \a Value gets RAUW'ed and the target already exists, this is used to
  /// merge the two metadata nodes.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueAsMetadata::replaceAllUsesWith">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 360,
   FQN="llvm::ValueAsMetadata::replaceAllUsesWith", NM="_ZN4llvm15ValueAsMetadata18replaceAllUsesWithEPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15ValueAsMetadata18replaceAllUsesWithEPNS_8MetadataE")
  //</editor-fold>
  public/*protected*/ void replaceAllUsesWith(Metadata /*P*/ MD) {
    ReplaceableMetadataImpl.super.replaceAllUsesWith(MD);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueAsMetadata::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 365,
   FQN="llvm::ValueAsMetadata::classof", NM="_ZN4llvm15ValueAsMetadata7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm15ValueAsMetadata7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    return MD.getMetadataID() == MetadataKind.LocalAsMetadataKind.getValue()
       || MD.getMetadataID() == MetadataKind.ConstantAsMetadataKind.getValue();
  }

  
  private final ReplaceableMetadataImpl$Fields ReplaceableMetadataImpl$Flds;// use return value of $ReplaceableMetadataImpl();
  @Override public final ReplaceableMetadataImpl$Fields $ReplaceableMetadataImpl$Fields() { return ReplaceableMetadataImpl$Flds; }
  
  @Override public String toString() {
    return "" + "V=" + V // NOI18N
              + super.toString(); // NOI18N
  }
}
