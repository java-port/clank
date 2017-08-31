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

package org.clang.ast.comments;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;


/// An opening HTML tag with attributes.
//<editor-fold defaultstate="collapsed" desc="clang::comments::HTMLStartTagComment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 419,
 FQN="clang::comments::HTMLStartTagComment", NM="_ZN5clang8comments19HTMLStartTagCommentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments19HTMLStartTagCommentE")
//</editor-fold>
public class HTMLStartTagComment extends /*public*/ HTMLTagComment {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::comments::HTMLStartTagComment::Attribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 421,
   FQN="clang::comments::HTMLStartTagComment::Attribute", NM="_ZN5clang8comments19HTMLStartTagComment9AttributeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments19HTMLStartTagComment9AttributeE")
  //</editor-fold>
  public static class Attribute implements NativeCloneable<Attribute> {
  /*public:*/
    public SourceLocation NameLocBegin;
    public StringRef Name;
    
    public SourceLocation EqualsLoc;
    
    public SourceRange ValueRange;
    public StringRef Value;
    
    //<editor-fold defaultstate="collapsed" desc="clang::comments::HTMLStartTagComment::Attribute::Attribute">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 431,
     FQN="clang::comments::HTMLStartTagComment::Attribute::Attribute", NM="_ZN5clang8comments19HTMLStartTagComment9AttributeC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments19HTMLStartTagComment9AttributeC1Ev")
    //</editor-fold>
    public Attribute() {
      // : NameLocBegin(), Name(), EqualsLoc(), ValueRange(), Value() 
      //START JInit
      this.NameLocBegin = new SourceLocation();
      this.Name = new StringRef();
      this.EqualsLoc = new SourceLocation();
      this.ValueRange = new SourceRange();
      this.Value = new StringRef();
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::comments::HTMLStartTagComment::Attribute::Attribute">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 433,
     FQN="clang::comments::HTMLStartTagComment::Attribute::Attribute", NM="_ZN5clang8comments19HTMLStartTagComment9AttributeC1ENS_14SourceLocationEN4llvm9StringRefE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments19HTMLStartTagComment9AttributeC1ENS_14SourceLocationEN4llvm9StringRefE")
    //</editor-fold>
    public Attribute(SourceLocation NameLocBegin, StringRef Name) {
      // : NameLocBegin(NameLocBegin), Name(Name), EqualsLoc(SourceLocation()), ValueRange(SourceRange()), Value(StringRef()) 
      //START JInit
      this.NameLocBegin = new SourceLocation(NameLocBegin);
      this.Name = new StringRef(Name);
      this.EqualsLoc = new SourceLocation();
      this.ValueRange = new SourceRange();
      this.Value = new StringRef();
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::comments::HTMLStartTagComment::Attribute::Attribute">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 439,
     FQN="clang::comments::HTMLStartTagComment::Attribute::Attribute", NM="_ZN5clang8comments19HTMLStartTagComment9AttributeC1ENS_14SourceLocationEN4llvm9StringRefES3_NS_11SourceRangeES5_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments19HTMLStartTagComment9AttributeC1ENS_14SourceLocationEN4llvm9StringRefES3_NS_11SourceRangeES5_")
    //</editor-fold>
    public Attribute(SourceLocation NameLocBegin, StringRef Name, 
        SourceLocation EqualsLoc, 
        SourceRange ValueRange, StringRef Value) {
      // : NameLocBegin(NameLocBegin), Name(Name), EqualsLoc(EqualsLoc), ValueRange(ValueRange), Value(Value) 
      //START JInit
      this.NameLocBegin = new SourceLocation(NameLocBegin);
      this.Name = new StringRef(Name);
      this.EqualsLoc = new SourceLocation(EqualsLoc);
      this.ValueRange = new SourceRange(ValueRange);
      this.Value = new StringRef(Value);
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::comments::HTMLStartTagComment::Attribute::getNameLocEnd">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 447,
     FQN="clang::comments::HTMLStartTagComment::Attribute::getNameLocEnd", NM="_ZNK5clang8comments19HTMLStartTagComment9Attribute13getNameLocEndEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19HTMLStartTagComment9Attribute13getNameLocEndEv")
    //</editor-fold>
    public SourceLocation getNameLocEnd() /*const*/ {
      return NameLocBegin.getLocWithOffset(Name.size());
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::comments::HTMLStartTagComment::Attribute::getNameRange">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 451,
     FQN="clang::comments::HTMLStartTagComment::Attribute::getNameRange", NM="_ZNK5clang8comments19HTMLStartTagComment9Attribute12getNameRangeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19HTMLStartTagComment9Attribute12getNameRangeEv")
    //</editor-fold>
    public SourceRange getNameRange() /*const*/ {
      return new SourceRange(/*NO_COPY*/NameLocBegin, getNameLocEnd());
    }


    //<editor-fold defaultstate="collapsed" desc="clang::comments::HTMLStartTagComment::Attribute::Attribute">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 421,
     FQN="clang::comments::HTMLStartTagComment::Attribute::Attribute", NM="_ZN5clang8comments19HTMLStartTagComment9AttributeC1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments19HTMLStartTagComment9AttributeC1ERKS2_")
    //</editor-fold>
    public /*inline*/ Attribute(final /*const*/ Attribute /*&*/ $Prm0) {
      // : NameLocBegin(.NameLocBegin), Name(.Name), EqualsLoc(.EqualsLoc), ValueRange(.ValueRange), Value(.Value) 
      //START JInit
      this.NameLocBegin = new SourceLocation($Prm0.NameLocBegin);
      this.Name = new StringRef($Prm0.Name);
      this.EqualsLoc = new SourceLocation($Prm0.EqualsLoc);
      this.ValueRange = new SourceRange($Prm0.ValueRange);
      this.Value = new StringRef($Prm0.Value);
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::comments::HTMLStartTagComment::Attribute::~Attribute">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 421,
     FQN="clang::comments::HTMLStartTagComment::Attribute::~Attribute", NM="_ZN5clang8comments19HTMLStartTagComment9AttributeD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments19HTMLStartTagComment9AttributeD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
    }

    @Override
    public Attribute clone() {
      return new Attribute(this);
    }
    
    @Override public String toString() {
      return "" + "NameLocBegin=" + NameLocBegin // NOI18N
                + ", Name=" + Name // NOI18N
                + ", EqualsLoc=" + EqualsLoc // NOI18N
                + ", ValueRange=" + ValueRange // NOI18N
                + ", Value=" + Value; // NOI18N
    }
  };
/*private:*/
  private ArrayRef<Attribute> Attributes;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::comments::HTMLStartTagComment::HTMLStartTagComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 460,
   FQN="clang::comments::HTMLStartTagComment::HTMLStartTagComment", NM="_ZN5clang8comments19HTMLStartTagCommentC1ENS_14SourceLocationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments19HTMLStartTagCommentC1ENS_14SourceLocationEN4llvm9StringRefE")
  //</editor-fold>
  public HTMLStartTagComment(SourceLocation LocBegin, 
      StringRef TagName) {
    // : HTMLTagComment(HTMLStartTagCommentKind, LocBegin, LocBegin.getLocWithOffset(1 + TagName.size()), TagName, LocBegin.getLocWithOffset(1), LocBegin.getLocWithOffset(1 + TagName.size())), Attributes() 
    //START JInit
    super(CommentKind.HTMLStartTagCommentKind, 
        new SourceLocation(LocBegin), LocBegin.getLocWithOffset(1 + TagName.size()), 
        new StringRef(TagName), 
        LocBegin.getLocWithOffset(1), 
        LocBegin.getLocWithOffset(1 + TagName.size()));
    this.Attributes = new ArrayRef<Attribute>(false);
    //END JInit
    Unnamed_field2.HTMLStartTagCommentBits.IsSelfClosing = false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::HTMLStartTagComment::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 470,
   FQN="clang::comments::HTMLStartTagComment::classof", NM="_ZN5clang8comments19HTMLStartTagComment7classofEPKNS0_7CommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments19HTMLStartTagComment7classofEPKNS0_7CommentE")
  //</editor-fold>
  public static boolean classof(/*const*/ Comment /*P*/ C) {
    return C.getCommentKind() == CommentKind.HTMLStartTagCommentKind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::HTMLStartTagComment::child_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 474,
   FQN="clang::comments::HTMLStartTagComment::child_begin", NM="_ZNK5clang8comments19HTMLStartTagComment11child_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19HTMLStartTagComment11child_beginEv")
  //</editor-fold>
  public type$ptr<Comment/*P*/> child_begin() /*const*/ {
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::HTMLStartTagComment::child_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 476,
   FQN="clang::comments::HTMLStartTagComment::child_end", NM="_ZNK5clang8comments19HTMLStartTagComment9child_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19HTMLStartTagComment9child_endEv")
  //</editor-fold>
  public type$ptr<Comment/*P*/> child_end() /*const*/ {
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::HTMLStartTagComment::getNumAttrs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 478,
   FQN="clang::comments::HTMLStartTagComment::getNumAttrs", NM="_ZNK5clang8comments19HTMLStartTagComment11getNumAttrsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19HTMLStartTagComment11getNumAttrsEv")
  //</editor-fold>
  public /*uint*/int getNumAttrs() /*const*/ {
    return Attributes.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::HTMLStartTagComment::getAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 482,
   FQN="clang::comments::HTMLStartTagComment::getAttr", NM="_ZNK5clang8comments19HTMLStartTagComment7getAttrEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19HTMLStartTagComment7getAttrEj")
  //</editor-fold>
  public /*const*/ Attribute /*&*/ getAttr(/*uint*/int Idx) /*const*/ {
    return Attributes.$at(Idx);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::HTMLStartTagComment::setAttrs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 486,
   FQN="clang::comments::HTMLStartTagComment::setAttrs", NM="_ZN5clang8comments19HTMLStartTagComment8setAttrsEN4llvm8ArrayRefINS1_9AttributeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments19HTMLStartTagComment8setAttrsEN4llvm8ArrayRefINS1_9AttributeEEE")
  //</editor-fold>
  public void setAttrs(ArrayRef<Attribute> Attrs) {
    Attributes.$assign(Attrs);
    if (!Attrs.empty()) {
      final /*const*/ Attribute /*&*/ Attr = Attrs.back();
      SourceLocation L = Attr.ValueRange.getEnd();
      if (L.isValid()) {
        Range.setEnd(/*NO_COPY*/L);
      } else {
        Range.setEnd(Attr.getNameLocEnd());
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::HTMLStartTagComment::setGreaterLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 499,
   FQN="clang::comments::HTMLStartTagComment::setGreaterLoc", NM="_ZN5clang8comments19HTMLStartTagComment13setGreaterLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments19HTMLStartTagComment13setGreaterLocENS_14SourceLocationE")
  //</editor-fold>
  public void setGreaterLoc(SourceLocation GreaterLoc) {
    Range.setEnd(/*NO_COPY*/GreaterLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::HTMLStartTagComment::isSelfClosing">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 503,
   FQN="clang::comments::HTMLStartTagComment::isSelfClosing", NM="_ZNK5clang8comments19HTMLStartTagComment13isSelfClosingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19HTMLStartTagComment13isSelfClosingEv")
  //</editor-fold>
  public boolean isSelfClosing() /*const*/ {
    return Unnamed_field2.HTMLStartTagCommentBits.IsSelfClosing;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::HTMLStartTagComment::setSelfClosing">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 507,
   FQN="clang::comments::HTMLStartTagComment::setSelfClosing", NM="_ZN5clang8comments19HTMLStartTagComment14setSelfClosingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments19HTMLStartTagComment14setSelfClosingEv")
  //</editor-fold>
  public void setSelfClosing() {
    Unnamed_field2.HTMLStartTagCommentBits.IsSelfClosing = true;
  }

  
  @Override public String toString() {
    return "" + "Attributes=" + Attributes // NOI18N
              + super.toString(); // NOI18N
  }
}
