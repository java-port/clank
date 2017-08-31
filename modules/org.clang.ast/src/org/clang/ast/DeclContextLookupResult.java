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

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;


/// \brief The results of name lookup within a DeclContext. This is either a
/// single result (with no stable storage) or a collection of results (with
/// stable storage provided by the lookup table).
//<editor-fold defaultstate="collapsed" desc="clang::DeclContextLookupResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1067,
 FQN="clang::DeclContextLookupResult", NM="_ZN5clang23DeclContextLookupResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang23DeclContextLookupResultE")
//</editor-fold>
public class DeclContextLookupResult implements Iterable<NamedDecl /*P*/>, NativeMoveable<DeclContextLookupResult> {
  /*typedef ArrayRef<NamedDecl *> ResultTy*/
//  public final class ResultTy extends ArrayRef<NamedDecl /*P*/ >{ };
  private ArrayRef<NamedDecl /*P*/ > Result;
  // If there is only one lookup result, it would be invalidated by
  // reallocations of the name table, so store it separately.
  private NamedDecl /*P*/ Single;
  
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private static type$ptr<NamedDecl /*P*/> /*const*/ SingleElementDummyList = $toConst(create_type$ptr((NamedDecl[])null));
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContextLookupResult::DeclContextLookupResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1077,
   FQN="clang::DeclContextLookupResult::DeclContextLookupResult", NM="_ZN5clang23DeclContextLookupResultC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang23DeclContextLookupResultC1Ev")
  //</editor-fold>
  public DeclContextLookupResult() {
    // : Result(), Single(implicit NamedDecl * ()) 
    //START JInit
    this.Result = new ArrayRef<NamedDecl /*P*/ >(true);
    this.Single = /*implicit-init*/((NamedDecl /*P*/ )/*zero-init*/null);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclContextLookupResult::DeclContextLookupResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1078,
   FQN="clang::DeclContextLookupResult::DeclContextLookupResult", NM="_ZN5clang23DeclContextLookupResultC1EN4llvm8ArrayRefIPNS_9NamedDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang23DeclContextLookupResultC1EN4llvm8ArrayRefIPNS_9NamedDeclEEE")
  //</editor-fold>
  public DeclContextLookupResult(ArrayRef<NamedDecl /*P*/ > Result) {
    // : Result(Result), Single(implicit NamedDecl * ()) 
    //START JInit
    this.Result = new ArrayRef<NamedDecl /*P*/ >(Result);
    this.Single = /*implicit-init*/((NamedDecl /*P*/ )/*zero-init*/null);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclContextLookupResult::DeclContextLookupResult">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1080,
   FQN="clang::DeclContextLookupResult::DeclContextLookupResult", NM="_ZN5clang23DeclContextLookupResultC1EPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang23DeclContextLookupResultC1EPNS_9NamedDeclE")
  //</editor-fold>
  public DeclContextLookupResult(NamedDecl /*P*/ Single) {
    // : Result(SingleElementDummyList), Single(Single) 
    //START JInit
    this.Result = new ArrayRef<NamedDecl /*P*/ >(SingleElementDummyList, 1, true);
    this.Single = Single;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContextLookupResult::iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1087,
   FQN="clang::DeclContextLookupResult::iterator", NM="_ZN5clang23DeclContextLookupResult8iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang23DeclContextLookupResult8iteratorE")
  //</editor-fold>
  public static class iterator extends /*public*/ iterator_adaptor_base<iterator, type$ptr<NamedDecl /*P*/ /*const*/ /*P*/>, std.random_access_iterator_tag, NamedDecl /*P*/ /*const*/, NamedDecl /*P*/ /*const*/> {
    private /*const*/ NamedDecl SingleElement;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContextLookupResult::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1091,
     FQN="clang::DeclContextLookupResult::iterator::iterator", NM="_ZN5clang23DeclContextLookupResult8iteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang23DeclContextLookupResult8iteratorC1Ev")
    //</editor-fold>
    public iterator() {
      // : IteratorBase(), SingleElement(implicit value_type()) 
      //START JInit
      super();
      this.SingleElement = /*implicit-init*/((NamedDecl /*P*/ )/*zero-init*/null);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclContextLookupResult::iterator::iterator">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1092,
     FQN="clang::DeclContextLookupResult::iterator::iterator", NM="_ZN5clang23DeclContextLookupResult8iteratorC1EPKPNS_9NamedDeclES3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang23DeclContextLookupResult8iteratorC1EPKPNS_9NamedDeclES3_")
    //</editor-fold>
    public /*explicit*/ iterator(type$ptr<NamedDecl /*P*/> /*const*/ Pos) {
      this(Pos, (/*const*/ NamedDecl)null);
    }
    public /*explicit*/ iterator(type$ptr<NamedDecl /*P*/> /*const*/ Pos, /*const*/ NamedDecl Single/*= null*/) {
      // : IteratorBase(Pos), SingleElement(Single) 
      //START JInit
      super(Pos);
      this.SingleElement = Single;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::DeclContextLookupResult::iterator::operator*">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1095,
     FQN="clang::DeclContextLookupResult::iterator::operator*", NM="_ZNK5clang23DeclContextLookupResult8iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang23DeclContextLookupResult8iteratordeEv")
    //</editor-fold>
    public NamedDecl /*P*/ /*const*/ $star() /*const*/ {
      return (SingleElement != null) ? SingleElement : super.I.$star();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclContextLookupResult::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1087,
     FQN="clang::DeclContextLookupResult::iterator::iterator", NM="_ZN5clang23DeclContextLookupResult8iteratorC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang23DeclContextLookupResult8iteratorC1ERKS1_")
    //</editor-fold>
    public /*inline*/ iterator(final /*const*/ iterator /*&*/ $Prm0) {
      // : IteratorBase(), SingleElement(.SingleElement) 
      //START JInit
      super(JD$BaseOf.INSTANCE, $Prm0);
      this.SingleElement = $Prm0.SingleElement;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DeclContextLookupResult::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1087,
     FQN="clang::DeclContextLookupResult::iterator::iterator", NM="_ZN5clang23DeclContextLookupResult8iteratorC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang23DeclContextLookupResult8iteratorC1EOS1_")
    //</editor-fold>
    public /*inline*/ iterator(JD$Move _dparam, final iterator /*&&*/$Prm0) {
      // : IteratorBase(static_cast<iterator &&>()), SingleElement(static_cast<iterator &&>().SingleElement) 
      //START JInit
      super(JD$Move.INSTANCE, $Prm0);
      this.SingleElement = $Prm0.SingleElement;
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Override public iterator clone() { return new iterator(this); }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "SingleElement=" + SingleElement // NOI18N
                + super.toString(); // NOI18N
    }
  };
  /*typedef llvm::iterator_adaptor_base<iterator, ResultTy::iterator, std::random_access_iterator_tag, NamedDecl *const> IteratorBase*/
//  public final class IteratorBase extends iterator_adaptor_base<iterator, type$ptr<NamedDecl /*P*/ /*const*/ /*P*/>, std.random_access_iterator_tag, NamedDecl /*P*/ /*const*/>{ };
  ;
  /*typedef iterator const_iterator*/
//  public final class const_iterator extends iterator{ };
  /*typedef iterator::pointer pointer*/
//  public final class pointer extends type$ptr<NamedDecl /*P*/ /*const*/ /*P*/>{ };
  /*typedef iterator::reference reference*/
//  public final class reference extends iterator.reference{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContextLookupResult::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1103,
   FQN="clang::DeclContextLookupResult::begin", NM="_ZNK5clang23DeclContextLookupResult5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang23DeclContextLookupResult5beginEv")
  //</editor-fold>
  public iterator begin() /*const*/ {
    return new iterator(Result.begin(), Single);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclContextLookupResult::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1104,
   FQN="clang::DeclContextLookupResult::end", NM="_ZNK5clang23DeclContextLookupResult3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang23DeclContextLookupResult3endEv")
  //</editor-fold>
  public iterator end() /*const*/ {
    return new iterator(Result.end(), Single);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContextLookupResult::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1106,
   FQN="clang::DeclContextLookupResult::empty", NM="_ZNK5clang23DeclContextLookupResult5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang23DeclContextLookupResult5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return Result.empty();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclContextLookupResult::data">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1107,
   FQN="clang::DeclContextLookupResult::data", NM="_ZNK5clang23DeclContextLookupResult4dataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang23DeclContextLookupResult4dataEv")
  //</editor-fold>
  public type$ptr<NamedDecl /*P*/> /*const*/ data() /*const*/ {
    return (Single != null) ? $AddrOf(create_type$ptr2ConstT(Single)) : Result.data();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclContextLookupResult::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1108,
   FQN="clang::DeclContextLookupResult::size", NM="_ZNK5clang23DeclContextLookupResult4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang23DeclContextLookupResult4sizeEv")
  //</editor-fold>
  public /*size_t*/int size() /*const*/ {
    return (Single != null) ? 1 : Result.size();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclContextLookupResult::front">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1109,
   FQN="clang::DeclContextLookupResult::front", NM="_ZNK5clang23DeclContextLookupResult5frontEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang23DeclContextLookupResult5frontEv")
  //</editor-fold>
  public NamedDecl /*P*/ /*const*/ front() /*const*/ {
    return (Single != null) ? Single : Result.front();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclContextLookupResult::back">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1110,
   FQN="clang::DeclContextLookupResult::back", NM="_ZNK5clang23DeclContextLookupResult4backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang23DeclContextLookupResult4backEv")
  //</editor-fold>
  public NamedDecl /*P*/ /*const*/ back() /*const*/ {
    return (Single != null) ? Single : Result.back();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclContextLookupResult::operator[]">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1111,
   FQN="clang::DeclContextLookupResult::operator[]", NM="_ZNK5clang23DeclContextLookupResultixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang23DeclContextLookupResultixEj")
  //</editor-fold>
  public NamedDecl /*P*/ /*const*/ $at(/*size_t*/int N) /*const*/ {
    return (Single != null) ? Single : Result.$at(N);
  }

  
  // FIXME: Remove this from the interface
  //<editor-fold defaultstate="collapsed" desc="clang::DeclContextLookupResult::slice">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1114,
   FQN="clang::DeclContextLookupResult::slice", NM="_ZNK5clang23DeclContextLookupResult5sliceEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK5clang23DeclContextLookupResult5sliceEj")
  //</editor-fold>
  public DeclContextLookupResult slice(/*size_t*/int N) /*const*/ {
    DeclContextLookupResult Sliced = new DeclContextLookupResult(Result.slice(N));
    Sliced.Single = Single;
    return Sliced;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclContextLookupResult::DeclContextLookupResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1067,
   FQN="clang::DeclContextLookupResult::DeclContextLookupResult", NM="_ZN5clang23DeclContextLookupResultC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang23DeclContextLookupResultC1ERKS0_")
  //</editor-fold>
  public /*inline*/ DeclContextLookupResult(final /*const*/ DeclContextLookupResult /*&*/ $Prm0) {
    // : Result(.Result), Single(.Single) 
    //START JInit
    this.Result = new ArrayRef<NamedDecl /*P*/ >($Prm0.Result);
    this.Single = $Prm0.Single;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclContextLookupResult::DeclContextLookupResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1067,
   FQN="clang::DeclContextLookupResult::DeclContextLookupResult", NM="_ZN5clang23DeclContextLookupResultC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang23DeclContextLookupResultC1EOS0_")
  //</editor-fold>
  public /*inline*/ DeclContextLookupResult(JD$Move _dparam, final DeclContextLookupResult /*&&*/$Prm0) {
    // : Result(static_cast<DeclContextLookupResult &&>().Result), Single(static_cast<DeclContextLookupResult &&>().Single) 
    //START JInit
    this.Result = new ArrayRef<NamedDecl /*P*/ >(JD$Move.INSTANCE, $Prm0.Result);
    this.Single = $Prm0.Single;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclContextLookupResult::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1067,
   FQN="clang::DeclContextLookupResult::operator=", NM="_ZN5clang23DeclContextLookupResultaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN5clang23DeclContextLookupResultaSEOS0_")
  //</editor-fold>
  public /*inline*/ DeclContextLookupResult /*&*/ $assignMove(final DeclContextLookupResult /*&&*/$Prm0) {
    this.Result.$assignMove($Prm0.Result);
    this.Single = $Prm0.Single;
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public java.util.Iterator<NamedDecl /*P*/> iterator() {
    return new JavaIterator(begin(), end());
  }

  @Override
  public DeclContextLookupResult move() {
    return new DeclContextLookupResult(JD$Move.INSTANCE, this);
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return Single == null ? ("Result=" + Result) // NOI18N
            : ("Single=" + Single); // NOI18N
  }
}
