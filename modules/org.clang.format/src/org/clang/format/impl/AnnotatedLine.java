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

package org.clang.format.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::format::AnnotatedLine">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.h", line = 39,
 FQN="clang::format::AnnotatedLine", NM="_ZN5clang6format13AnnotatedLineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format13AnnotatedLineE")
//</editor-fold>
public class AnnotatedLine implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::AnnotatedLine::AnnotatedLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.h", line = 41,
   FQN="clang::format::AnnotatedLine::AnnotatedLine", NM="_ZN5clang6format13AnnotatedLineC1ERKNS0_13UnwrappedLineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format13AnnotatedLineC1ERKNS0_13UnwrappedLineE")
  //</editor-fold>
  public AnnotatedLine(final /*const*/ UnwrappedLine /*&*/ Line) {
    // : First(Line.Tokens.front().Tok), Children(), Level(Line.Level), InPPDirective(Line.InPPDirective), MustBeDeclaration(Line.MustBeDeclaration), MightBeFunctionDecl(false), IsMultiVariableDeclStmt(false), Affected(false), LeadingEmptyLinesAffected(false), ChildrenAffected(false) 
    //START JInit
    this.First = Line.Tokens.front$Const().Tok;
    this.Children = new SmallVector<AnnotatedLine /*P*/ >(0, (AnnotatedLine /*P*/ )null);
    this.Level = Line.Level;
    this.InPPDirective = Line.InPPDirective;
    this.MustBeDeclaration = Line.MustBeDeclaration;
    this.MightBeFunctionDecl = false;
    this.IsMultiVariableDeclStmt = false;
    this.Affected = false;
    this.LeadingEmptyLinesAffected = false;
    this.ChildrenAffected = false;
    //END JInit
    assert (!Line.Tokens.empty());
    
    // Calculate Next and Previous for all tokens. Note that we must overwrite
    // Next and Previous for every token, as previous formatting runs might have
    // left them in a different state.
    First.Previous = null;
    FormatToken /*P*/ Current = First;
    for (std.list.iterator<UnwrappedLineNode> I = new std.list.iterator<UnwrappedLineNode>(Line.Tokens.begin$Const().$preInc()), 
        E = Line.Tokens.end$Const();
         I.$noteq(E); I.$preInc()) {
      final /*const*/ UnwrappedLineNode /*&*/ Node = I.$star();
      Current.Next = I.$arrow().Tok;
      I.$arrow().Tok.Previous = Current;
      Current = Current.Next;
      Current.Children.clear();
      for (final /*const*/ UnwrappedLine /*&*/ Child : Node.Children) {
        Children.push_back(new AnnotatedLine(Child));
        Current.Children.push_back(Children.back());
      }
    }
    Last = Current;
    Last.Next = null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::AnnotatedLine::~AnnotatedLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.h", line = 71,
   FQN="clang::format::AnnotatedLine::~AnnotatedLine", NM="_ZN5clang6format13AnnotatedLineD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format13AnnotatedLineD0Ev")
  //</editor-fold>
  public void $destroy() {
    for (/*uint*/int i = 0, e = Children.size(); i != e; ++i) {
      if (Children.$at(i) != null) { Children.$at(i).$destroy();};
    }
    FormatToken /*P*/ Current = First;
    while ((Current != null)) {
      Current.Children.clear();
      Current.Role.reset();
      Current = Current.Next;
    }
    //START JDestroy
    Children.$destroy();
    //END JDestroy
  }

  
  /// \c true if this line starts with the given tokens in order, ignoring
  /// comments.
  //</*typename*/ /*...*/ Ts/* = <TokenKind>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::AnnotatedLine::startsWith">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.h", line = 85,
   FQN="clang::format::AnnotatedLine::startsWith", NM="_ZNK5clang6format13AnnotatedLine10startsWithIJNS_3tok9TokenKindEEEEbDpT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format13AnnotatedLine10startsWithIJNS_3tok9TokenKindEEEEbDpT_")
  //</editor-fold>
  public boolean startsWith(/*tok.TokenKind*/char Tokens) /*const*/ {
    return (First != null) && First.startsSequence(Tokens);
  }
  //</*typename*/ /*...*/ Ts/* = <IdentifierInfo *, TokenKind>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::AnnotatedLine::startsWith">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.h", line = 85,
   FQN="clang::format::AnnotatedLine::startsWith", NM="_ZNK5clang6format13AnnotatedLine10startsWithIJPNS_14IdentifierInfoENS_3tok9TokenKindEEEEbDpT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format13AnnotatedLine10startsWithIJPNS_14IdentifierInfoENS_3tok9TokenKindEEEEbDpT_")
  //</editor-fold>
  public boolean startsWith(IdentifierInfo /*P*/ Tokens, /*tok.TokenKind*/char Tokens$1) /*const*/ {
    return (First != null) && First.startsSequence(Tokens, Tokens$1);
  }
  //</*typename*/ /*...*/ Ts/* = <TokenType>*/>
  //<editor-fold defaultstate="collapsed" desc="clang::format::AnnotatedLine::startsWith">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.h", line = 85,
   FQN="clang::format::AnnotatedLine::startsWith", NM="_ZNK5clang6format13AnnotatedLine10startsWithIJNS0_9TokenTypeEEEEbDpT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format13AnnotatedLine10startsWithIJNS0_9TokenTypeEEEEbDpT_")
  //</editor-fold>
  public boolean startsWith(TokenType Tokens) /*const*/ {
    return (First != null) && First.startsSequence(Tokens);
  }
  //</*typename*/ /*...*/ Ts/* = <TokenKind, TokenKind>*/> 
//<editor-fold defaultstate="collapsed" desc="clang::format::AnnotatedLine::startsWith">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.h", line = 85,
   FQN="clang::format::AnnotatedLine::startsWith", NM="_ZNK5clang6format13AnnotatedLine10startsWithIJNS_3tok9TokenKindES4_EEEbDpT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format13AnnotatedLine10startsWithIJNS_3tok9TokenKindES4_EEEbDpT_")
  //</editor-fold>
  public boolean startsWith(/*tok.TokenKind*/char Tokens, /*tok.TokenKind*/char Tokens$1) /*const*/ {
    return (First != null) && First.startsSequence(Tokens, Tokens$1);
  }
//  /*template <typename ... Ts> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="clang::format::AnnotatedLine::startsWith">
//  @Converted(kind = Converted.Kind.DELETED,
//   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.h", line = 85,
//   FQN="clang::format::AnnotatedLine::startsWith", NM="Tpl__ZNK5clang6format13AnnotatedLine10startsWithEDpT_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=Tpl__ZNK5clang6format13AnnotatedLine10startsWithEDpT_")
//  //</editor-fold>
//  public </*typename*/ /*...*/ Ts> boolean startsWith(Ts ...Tokens) /*const*/ {
//    return Native.$bool(First) && Native.$bool(First.startsSequence(Tokens...));
//  }


  /// \c true if this line ends with the given tokens in reversed order,
  /// ignoring comments.
  /// For example, given tokens [T1, T2, T3, ...], the function returns true if
  /// this line is like "... T3 T2 T1".
  //</*typename*/ /*...*/ Ts/* = <TokenKind>*/> 
  //<editor-fold defaultstate="collapsed" desc="clang::format::AnnotatedLine::endsWith">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.h", line = 93,
   FQN="clang::format::AnnotatedLine::endsWith", NM="_ZNK5clang6format13AnnotatedLine8endsWithIJNS_3tok9TokenKindEEEEbDpT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZNK5clang6format13AnnotatedLine8endsWithIJNS_3tok9TokenKindEEEEbDpT_")
  //</editor-fold>
  public boolean endsWith(/*tok.TokenKind*/char Tokens) /*const*/ {
    return (Last != null) && Last.endsSequence(Tokens);
  }
//  /*template <typename ... Ts> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="clang::format::AnnotatedLine::endsWith">
//  @Converted(kind = Converted.Kind.DELETED,
//   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.h", line = 93,
//   FQN="clang::format::AnnotatedLine::endsWith", NM="Tpl__ZNK5clang6format13AnnotatedLine8endsWithEDpT_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=Tpl__ZNK5clang6format13AnnotatedLine8endsWithEDpT_")
//  //</editor-fold>
//  public </*typename*/ /*...*/ Ts> boolean endsWith(Ts ...Tokens) /*const*/ {
//    return Native.$bool(Last) && Native.$bool(Last.endsSequence(Tokens...));
//  }


  /// \c true if this line looks like a function definition instead of a
  /// function declaration. Asserts MightBeFunctionDecl.
  //<editor-fold defaultstate="collapsed" desc="clang::format::AnnotatedLine::mightBeFunctionDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.h", line = 99,
   FQN="clang::format::AnnotatedLine::mightBeFunctionDefinition", NM="_ZNK5clang6format13AnnotatedLine25mightBeFunctionDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZNK5clang6format13AnnotatedLine25mightBeFunctionDefinitionEv")
  //</editor-fold>
  public boolean mightBeFunctionDefinition() /*const*/ {
    assert (MightBeFunctionDecl);
    // FIXME: Line.Last points to other characters than tok::semi
    // and tok::lbrace.
    return !Last.isOneOf(tok.TokenKind.semi, tok.TokenKind.comment);
  }

  
  public FormatToken /*P*/ First;
  public FormatToken /*P*/ Last;
  
  public SmallVector<AnnotatedLine /*P*/ > Children;
  
  public LineType Type;
  public /*uint*/int Level;
  public boolean InPPDirective;
  public boolean MustBeDeclaration;
  public boolean MightBeFunctionDecl;
  public boolean IsMultiVariableDeclStmt;
  
  /// \c True if this line should be formatted, i.e. intersects directly or
  /// indirectly with one of the input ranges.
  public boolean Affected;
  
  /// \c True if the leading empty lines of this line intersect with one of the
  /// input ranges.
  public boolean LeadingEmptyLinesAffected;
  
  /// \c True if a one of this line's children intersects with an input range.
  public boolean ChildrenAffected;
/*private:*/
  // Disallow copying.
  //<editor-fold defaultstate="collapsed" desc="clang::format::AnnotatedLine::AnnotatedLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.h", line = 131,
   FQN="clang::format::AnnotatedLine::AnnotatedLine", NM="_ZN5clang6format13AnnotatedLineC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format13AnnotatedLineC1ERKS1_")
  //</editor-fold>
  protected/*private*/ AnnotatedLine(final /*const*/ AnnotatedLine /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::format::AnnotatedLine::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.h", line = 132,
   FQN="clang::format::AnnotatedLine::operator=", NM="_ZN5clang6format13AnnotatedLineaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnnotator.cpp -nm=_ZN5clang6format13AnnotatedLineaSERKS1_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ AnnotatedLine /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  @Override public String toString() {
    return "" + "First=" + First // NOI18N
              + ", Last=" + Last // NOI18N
              + ", Children=" + Children // NOI18N
              + ", Type=" + Type // NOI18N
              + ", Level=" + Level // NOI18N
              + ", InPPDirective=" + InPPDirective // NOI18N
              + ", MustBeDeclaration=" + MustBeDeclaration // NOI18N
              + ", MightBeFunctionDecl=" + MightBeFunctionDecl // NOI18N
              + ", IsMultiVariableDeclStmt=" + IsMultiVariableDeclStmt // NOI18N
              + ", Affected=" + Affected // NOI18N
              + ", LeadingEmptyLinesAffected=" + LeadingEmptyLinesAffected // NOI18N
              + ", ChildrenAffected=" + ChildrenAffected; // NOI18N
  }
}
