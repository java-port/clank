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
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import static org.clang.ast.ASTContextGlobals.*;
import static org.clang.ast.java.AstMemberPointers.*;


/// \brief A lazy value (of type T) that is within an AST node of type Owner,
/// where the value might change in later generations of the external AST
/// source.
/*template <typename Owner, typename T, void (ExternalASTSource::*)(Owner) Update> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::LazyGenerationalUpdatePtr">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*moved the Update template arg into ctr leading argument, used instantiation for method bodies*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 385,
 FQN="clang::LazyGenerationalUpdatePtr", NM="_ZN5clang25LazyGenerationalUpdatePtrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang25LazyGenerationalUpdatePtrE")
//</editor-fold>
public class/*struct*/ LazyGenerationalUpdatePtr</*typename*/ Owner extends Decl, /*typename*/ T extends Decl/*, Update extends ExternalASTSource$Decl2Void*/>  {
  
  /// A cache of the value of this pointer, in the most recent generation in
  /// which we queried it.
  //<editor-fold defaultstate="collapsed" desc="clang::LazyGenerationalUpdatePtr::LazyData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 389,
   FQN="clang::LazyGenerationalUpdatePtr::LazyData", NM="_ZN5clang25LazyGenerationalUpdatePtr8LazyDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang25LazyGenerationalUpdatePtr8LazyDataE")
  //</editor-fold>
  public static class/*struct*/ LazyData<T> {
    //<editor-fold defaultstate="collapsed" desc="clang::LazyGenerationalUpdatePtr::LazyData::LazyData">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 390,
     FQN="clang::LazyGenerationalUpdatePtr::LazyData::LazyData", NM="_ZN5clang25LazyGenerationalUpdatePtr8LazyDataC1EPNS_17ExternalASTSourceET0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang25LazyGenerationalUpdatePtr8LazyDataC1EPNS_17ExternalASTSourceET0_")
    //</editor-fold>
    public LazyData(ExternalASTSource /*P*/ Source, T Value) {
      // : ExternalSource(Source), LastGeneration(0), LastValue(Value) 
      //START JInit
      this.ExternalSource = Source;
      this.LastGeneration = 0;
      this.LastValue = /*ParenListExpr*/Value;
      //END JInit
    }

    public ExternalASTSource /*P*/ ExternalSource;
    public /*uint32_t*/int LastGeneration;
    public T LastValue;
    
    @Override public String toString() {
      return "" + "ExternalSource=" + "[ExternalASTSource]" // NOI18N
                + ", LastGeneration=" + LastGeneration // NOI18N
                + ", LastValue=" + LastValue; // NOI18N
    }
  };
  
  // Our value is represented as simply T if there is no external AST source.
  /*typedef llvm::PointerUnion<T, LazyData *> ValueType*/
//  public final class ValueType extends PointerUnion<T, LazyData /*P*/ >{ };
  public PointerUnion<? extends Decl/*P*/, LazyData<T/*P*/> /*P*/ > Value;
  
  //<editor-fold defaultstate="collapsed" desc="clang::LazyGenerationalUpdatePtr::LazyGenerationalUpdatePtr<Owner, T, Update>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 401,
   FQN="clang::LazyGenerationalUpdatePtr::LazyGenerationalUpdatePtr<Owner, T, Update>", NM="_ZN5clang25LazyGenerationalUpdatePtrC1EN4llvm12PointerUnionIT0_PNS0_8LazyDataEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang25LazyGenerationalUpdatePtrC1EN4llvm12PointerUnionIT0_PNS0_8LazyDataEEE")
  //</editor-fold>
  public LazyGenerationalUpdatePtr(ExternalASTSource$Decl2Void $Update, PointerUnion<T, LazyData<T> /*P*/ > V) {
    this.$Update = $Update;
    // : Value(V) 
    //START JInit
    this.Value = new PointerUnion<T, LazyData<T> /*P*/ >(V);
    //END JInit
  }

  
  // Defined in ASTContext.h
  
  /// \brief Create the representation of a LazyGenerationalUpdatePtr.
  //<editor-fold defaultstate="collapsed" desc="clang::LazyGenerationalUpdatePtr::makeValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*used instantiation*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 2701,
   FQN="clang::LazyGenerationalUpdatePtr::makeValue", NM="_ZN5clang25LazyGenerationalUpdatePtr9makeValueERKNS_10ASTContextET0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang25LazyGenerationalUpdatePtr9makeValueERKNS_10ASTContextET0_")
  //</editor-fold>
  public static <T extends Decl> PointerUnion<T, LazyData<T> /*P*/ > makeValue(/*const*/ ASTContext /*&*/ Ctx, T Value) {
    {
      // Note, this is implemented here so that ExternalASTSource.h doesn't need to
      // include ASTContext.h. We explicitly instantiate it for all relevant types
      // in ASTContext.cpp.
      ExternalASTSource /*P*/ Source = Ctx.getExternalSource();
      if ((Source != null)) {
        return new PointerUnion(JD$T1.INSTANCE, LazyData /*P*/.class, /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
            /*new (Ctx)*/ $new_uint_ASTContext$C_uint(Ctx, (type$ptr<?> New$Mem)->{
                return new LazyData(Source, Value);
             }));
      }
    }
    return new PointerUnion(JD$T.INSTANCE, Decl /*P*/.class, Value);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::LazyGenerationalUpdatePtr::LazyGenerationalUpdatePtr<Owner, T, Update>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*split ctr to be able create default value*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 407,
   FQN="clang::LazyGenerationalUpdatePtr::LazyGenerationalUpdatePtr<Owner, T, Update>", NM="_ZN5clang25LazyGenerationalUpdatePtrC1ERKNS_10ASTContextET0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang25LazyGenerationalUpdatePtrC1ERKNS_10ASTContextET0_")
  //</editor-fold>
  public /*explicit*/ LazyGenerationalUpdatePtr(ExternalASTSource$Decl2Void $Update, /*const*/ ASTContext /*&*/ Ctx) {
    this($Update, Ctx, (T)null);
  }
  public /*explicit*/ LazyGenerationalUpdatePtr(ExternalASTSource$Decl2Void $Update, /*const*/ ASTContext /*&*/ Ctx, T Value/*= T()*/) {
    // : Value(makeValue(Ctx, Value)) 
    //START JInit
    this.Value = makeValue(Ctx, Value);
    //END JInit
    this.$Update = $Update;
  }

  
  /// Create a pointer that is not potentially updated by later generations of
  /// the external AST source.
  //<editor-fold defaultstate="collapsed" desc="clang::LazyGenerationalUpdatePtr::NotUpdatedTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 412,
   FQN="clang::LazyGenerationalUpdatePtr::NotUpdatedTag", NM="_ZN5clang25LazyGenerationalUpdatePtr13NotUpdatedTagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang25LazyGenerationalUpdatePtr13NotUpdatedTagE")
  //</editor-fold>
  public enum NotUpdatedTag implements Native.ComparableLower {
    NotUpdated(0);

    //<editor-fold defaultstate="collapsed" desc="hidden">
//    public static NotUpdatedTag valueOf(/*<dependent type>uint*/int val) {
//      NotUpdatedTag out = valueOf((int)val);
//      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]. Int not capable to keep values?";
//      return out;
//    }
    public static NotUpdatedTag valueOf(int val) {
      NotUpdatedTag out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final NotUpdatedTag[] VALUES;
      private static final NotUpdatedTag[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (NotUpdatedTag kind : NotUpdatedTag.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new NotUpdatedTag[min < 0 ? (1-min) : 0];
        VALUES = new NotUpdatedTag[max >= 0 ? (1+max) : 0];
        for (NotUpdatedTag kind : NotUpdatedTag.values()) {
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

    private final /*<dependent type>uint*/int value;
    private NotUpdatedTag(int val) { this.value = (/*<dependent type>uint*/int)val;}
    public /*<dependent type>uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((NotUpdatedTag)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((NotUpdatedTag)obj).value);}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="clang::LazyGenerationalUpdatePtr::LazyGenerationalUpdatePtr<Owner, T, Update>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*split ctr to be able create default value*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 413,
   FQN="clang::LazyGenerationalUpdatePtr::LazyGenerationalUpdatePtr<Owner, T, Update>", NM="_ZN5clang25LazyGenerationalUpdatePtrC1ENS0_13NotUpdatedTagET0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang25LazyGenerationalUpdatePtrC1ENS0_13NotUpdatedTagET0_")
  //</editor-fold>
  public LazyGenerationalUpdatePtr(ExternalASTSource$Decl2Void $Update, NotUpdatedTag $Prm0) {
    this($Update, $Prm0, (T)null);
  }
  public LazyGenerationalUpdatePtr(ExternalASTSource$Decl2Void $Update,NotUpdatedTag $Prm0, T Value/*= T()*/) {
    // : Value(Value) 
    //START JInit
    this.Value = /*ParenListExpr*/new PointerUnion(JD$T.INSTANCE, Decl.class, Value);
    //END JInit
    this.$Update = $Update;
  }
  
  
  /// Forcibly set this pointer (which must be lazy) as needing updates.
  //<editor-fold defaultstate="collapsed" desc="clang::LazyGenerationalUpdatePtr::markIncomplete">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 417,
   FQN="clang::LazyGenerationalUpdatePtr::markIncomplete", NM="_ZN5clang25LazyGenerationalUpdatePtr14markIncompleteEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang25LazyGenerationalUpdatePtr14markIncompleteEv")
  //</editor-fold>
  public void markIncomplete() {
    Value./*template */<LazyData /*P*/ >get(LazyData /*P*/.class).LastGeneration = 0;
  }

  
  /// Set the value of this pointer, in the current generation.
  //<editor-fold defaultstate="collapsed" desc="clang::LazyGenerationalUpdatePtr::set">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*used instantiation*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 422,
   FQN="clang::LazyGenerationalUpdatePtr::set", NM="_ZN5clang25LazyGenerationalUpdatePtr3setET0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang25LazyGenerationalUpdatePtr3setET0_")
  //</editor-fold>
  public void set(T NewValue) {
    {
      LazyData /*P*/ LazyVal = Value.dyn_cast(LazyData /*P*/.class);
      if ((LazyVal != null)) {
        LazyVal.LastValue = NewValue;
        return;
      }
    }
    ((PointerUnion)Value).$assign_T$C$R(Decl /*P*/ /*const*/ /*&*/.class, NewValue);
  }

  
  /// Set the value of this pointer, for this and all future generations.
  //<editor-fold defaultstate="collapsed" desc="clang::LazyGenerationalUpdatePtr::setNotUpdated">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*used instantiation*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 431,
   FQN="clang::LazyGenerationalUpdatePtr::setNotUpdated", NM="_ZN5clang25LazyGenerationalUpdatePtr13setNotUpdatedET0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang25LazyGenerationalUpdatePtr13setNotUpdatedET0_")
  //</editor-fold>
  public void setNotUpdated(T NewValue) {
    ((PointerUnion)Value).$assign_T$C$R(Decl /*P*/ /*const*/ /*&*/.class, NewValue);
  }

  
  /// Get the value of this pointer, updating its owner if necessary.
  //<editor-fold defaultstate="collapsed" desc="clang::LazyGenerationalUpdatePtr::get">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*used instantiation*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 434,
   FQN="clang::LazyGenerationalUpdatePtr::get", NM="_ZN5clang25LazyGenerationalUpdatePtr3getET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang25LazyGenerationalUpdatePtr3getET_")
  //</editor-fold>
  public T get(Owner Ownr) {
    {
      LazyData<T> /*P*/ LazyVal = Value.dyn_cast(LazyData /*P*/.class);
      if ((LazyVal != null)) {
        if (LazyVal.LastGeneration != LazyVal.ExternalSource.getGeneration()) {
          LazyVal.LastGeneration = LazyVal.ExternalSource.getGeneration();
          /*AddrOf*//*FPtr*/$Update.$call(/*PtrMemI*/LazyVal.ExternalSource, Ownr);
        }
        return LazyVal.LastValue;
      }
    }
    return (T)Value.get(Decl /*P*/.class);
  }

  
  /// Get the most recently computed value of this pointer without updating it.
  //<editor-fold defaultstate="collapsed" desc="clang::LazyGenerationalUpdatePtr::getNotUpdated">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 446,
   FQN="clang::LazyGenerationalUpdatePtr::getNotUpdated", NM="_ZNK5clang25LazyGenerationalUpdatePtr13getNotUpdatedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZNK5clang25LazyGenerationalUpdatePtr13getNotUpdatedEv")
  //</editor-fold>
  public T getNotUpdated() /*const*/ {
    {
      LazyData<T> /*P*/ LazyVal = Value.dyn_cast(LazyData /*P*/.class);
      if ((LazyVal != null)) {
        return LazyVal.LastValue;
      }
    }
    return (T)Value.get(Decl /*P*/.class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LazyGenerationalUpdatePtr::getOpaqueValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 452,
   FQN="clang::LazyGenerationalUpdatePtr::getOpaqueValue", NM="_ZN5clang25LazyGenerationalUpdatePtr14getOpaqueValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang25LazyGenerationalUpdatePtr14getOpaqueValueEv")
  //</editor-fold>
  public Object/*void P*/ getOpaqueValue() {
    return Value.getOpaqueValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LazyGenerationalUpdatePtr::getFromOpaqueValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 453,
   FQN="clang::LazyGenerationalUpdatePtr::getFromOpaqueValue", NM="_ZN5clang25LazyGenerationalUpdatePtr18getFromOpaqueValueEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang25LazyGenerationalUpdatePtr18getFromOpaqueValueEPv")
  //</editor-fold>
  public static <Owner extends Decl, T extends Decl> LazyGenerationalUpdatePtr<Owner, T> getFromOpaqueValue(ExternalASTSource$Decl2Void Update, Object/*void P*/ Ptr) {
    PointerUnion<T, LazyData<T>> p = PointerUnion.<T, LazyData<T> /*P*/ >getFromOpaqueValue(Ptr);
    return new LazyGenerationalUpdatePtr<Owner, T>(Update, p);    
  }
          
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final ExternalASTSource$Decl2Void $Update;
    
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Value=" + Value; // NOI18N
  }  
}
