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

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.impl.*;


/// \brief This class represents all comments included in the translation unit,
/// sorted in order of appearance in the translation unit.
//<editor-fold defaultstate="collapsed" desc="clang::RawCommentList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RawCommentList.h", line = 182,
 FQN="clang::RawCommentList", NM="_ZN5clang14RawCommentListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang14RawCommentListE")
//</editor-fold>
public class RawCommentList implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::RawCommentList::RawCommentList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RawCommentList.h", line = 184,
   FQN="clang::RawCommentList::RawCommentList", NM="_ZN5clang14RawCommentListC1ERNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang14RawCommentListC1ERNS_13SourceManagerE")
  //</editor-fold>
  public RawCommentList(final SourceManager /*&*/ SourceMgr) {
    // : SourceMgr(SourceMgr), Comments() 
    //START JInit
    this./*&*/SourceMgr=/*&*/SourceMgr;
    this.Comments = new std.vector<RawComment /*P*/ >((RawComment /*P*/ )null);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RawCommentList::addComment">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp", line = 272,
   FQN="clang::RawCommentList::addComment", NM="_ZN5clang14RawCommentList10addCommentERKNS_10RawCommentERN4llvm20BumpPtrAllocatorImplINS4_15MallocAllocatorELj4096ELj4096EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZN5clang14RawCommentList10addCommentERKNS_10RawCommentERN4llvm20BumpPtrAllocatorImplINS4_15MallocAllocatorELj4096ELj4096EEE")
  //</editor-fold>
  public void addComment(final /*const*/ RawComment /*&*/ RC, 
            final BumpPtrAllocatorImpl /*&*/ Allocator) {
    if (RC.isInvalid()) {
      return;
    }
    
    // Check if the comments are not in source order.
    while (!Comments.empty()
       && !SourceMgr.isBeforeInTranslationUnit(Comments.back().getLocStart(), 
        RC.getLocStart())) {
      // If they are, just pop a few last comments that don't fit.
      // This happens if an \#include directive contains comments.
      Comments.pop_back();
    }
    
    // Ordinary comments are not interesting for us.
    if (RC.isOrdinary()) {
      return;
    }
    
    // If this is the first Doxygen comment, save it (because there isn't
    // anything to merge it with).
    if (Comments.empty()) {
      Comments.push_back_T$RR(/*NEW_EXPR [operator new] NM=_ZnwIN4llvm15MallocAllocatorELj4096ELj4096EEPvjRNS0_20BumpPtrAllocatorImplIT_XT0_EXT1_EEE*/
          /*new (Allocator)*/ RawComment.$new_uint_BumpPtrAllocatorImpl$AllocatorT$SlabSize$SizeThreshold(Allocator, (type$ptr<?> New$Mem)->{
              return new RawComment(RC);
           }));
      return;
    }
    
    final /*const*/ RawComment /*&*/ C1 = $Deref(Comments.back());
    final /*const*/ RawComment /*&*/ C2 = RC;
    
    // Merge comments only if there is only whitespace between them.
    // Can't merge trailing and non-trailing comments unless the second is
    // non-trailing ordinary in the same column, as in the case:
    //   int x; // documents x
    //          // more text
    // versus:
    //   int x; // documents x
    //   int y; // documents y
    // or:
    //   int x; // documents x
    //   // documents y
    //   int y;
    // Merge comments if they are on same or consecutive lines.
    if ((C1.isTrailingComment() == C2.isTrailingComment()
       || (C1.isTrailingComment() && !C2.isTrailingComment()
       && RawCommentListStatics.isOrdinaryKind(C2.getKind())
       && RawCommentListStatics.commentsStartOnSameColumn(SourceMgr, C1, C2)))
       && RawCommentListStatics.onlyWhitespaceBetween(SourceMgr, C1.getLocEnd(), C2.getLocStart(), 
        /*MaxNewlinesAllowed=*/ 1)) {
      SourceRange MergedRange/*J*/= new SourceRange(C1.getLocStart(), C2.getLocEnd());
      /*Deref*/Comments.back().$assignMove(new RawComment(SourceMgr, new SourceRange(MergedRange), true, 
              RC.isParseAllComments()));
    } else {
      Comments.push_back_T$RR(/*NEW_EXPR [operator new] NM=_ZnwIN4llvm15MallocAllocatorELj4096ELj4096EEPvjRNS0_20BumpPtrAllocatorImplIT_XT0_EXT1_EEE*/
          /*new (Allocator)*/ RawComment.$new_uint_BumpPtrAllocatorImpl$AllocatorT$SlabSize$SizeThreshold(Allocator, (type$ptr<?> New$Mem)->{
              return new RawComment(RC);
           }));
    }
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::RawCommentList::getComments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RawCommentList.h", line = 188,
   FQN="clang::RawCommentList::getComments", NM="_ZNK5clang14RawCommentList11getCommentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK5clang14RawCommentList11getCommentsEv")
  //</editor-fold>
  public ArrayRef<RawComment /*P*/ > getComments() /*const*/ {
    return new ArrayRef<RawComment /*P*/ >(Comments, true);
  }

/*private:*/
  private final SourceManager /*&*/ SourceMgr;
  private std.vector<RawComment /*P*/ > Comments;
  //<editor-fold defaultstate="collapsed" desc="clang::RawCommentList::addDeserializedComments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp", line = 327,
   FQN="clang::RawCommentList::addDeserializedComments", NM="_ZN5clang14RawCommentList23addDeserializedCommentsEN4llvm8ArrayRefIPNS_10RawCommentEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZN5clang14RawCommentList23addDeserializedCommentsEN4llvm8ArrayRefIPNS_10RawCommentEEE")
  //</editor-fold>
  /*friend*/public void addDeserializedComments(ArrayRef<RawComment /*P*/ > DeserializedComments) {
    std.vector<RawComment /*P*/ > MergedComments = null;
    try {
      MergedComments/*J*/= new std.vector<RawComment /*P*/ >((RawComment /*P*/ )null);
      MergedComments.reserve(Comments.size() + DeserializedComments.size());
      
      std.merge(Comments.begin(), Comments.end(), 
          DeserializedComments.begin(), DeserializedComments.end(), 
          std.back_inserter(MergedComments), 
          new BeforeThanCompareRawComment(SourceMgr));
      std.swap(Comments, MergedComments);
    } finally {
      if (MergedComments != null) { MergedComments.$destroy(); }
    }
  }


  
  /*friend  class ASTReader*/
  //<editor-fold defaultstate="collapsed" desc="clang::RawCommentList::~RawCommentList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RawCommentList.h", line = 182,
   FQN="clang::RawCommentList::~RawCommentList", NM="_ZN5clang14RawCommentListD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang14RawCommentListD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Comments.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "SourceMgr=" + "[SourceManager]" // NOI18N
              + ", Comments=" + Comments; // NOI18N
  }
}
