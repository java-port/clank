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

package org.clang.edit;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.edit.*;
import org.clang.edit.Commit.Edit;
import org.clang.lex.*;
import static org.clang.edit.FileOffset.*;
import static org.clang.edit.impl.EditedSourceStatics.*;

//<editor-fold defaultstate="collapsed" desc="clang::edit::EditedSource">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/EditedSource.h", line = 29,
 FQN="clang::edit::EditedSource", NM="_ZN5clang4edit12EditedSourceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZN5clang4edit12EditedSourceE")
//</editor-fold>
public class EditedSource implements Destructors.ClassWithDestructor {
  private /*const*/ SourceManager /*&*/ SourceMgr;
  private /*const*/ LangOptions /*&*/ LangOpts;
  private /*const*/ PPConditionalDirectiveRecord /*P*/ PPRec;
  
  //<editor-fold defaultstate="collapsed" desc="clang::edit::EditedSource::FileEdit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/EditedSource.h", line = 34,
   FQN="clang::edit::EditedSource::FileEdit", NM="_ZN5clang4edit12EditedSource8FileEditE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZN5clang4edit12EditedSource8FileEditE")
  //</editor-fold>
  private static class/*struct*/ FileEdit implements NativeCloneable<FileEdit> {
    public StringRef Text;
    public /*uint*/int RemoveLen;
    
    //<editor-fold defaultstate="collapsed" desc="clang::edit::EditedSource::FileEdit::FileEdit">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/EditedSource.h", line = 38,
     FQN="clang::edit::EditedSource::FileEdit::FileEdit", NM="_ZN5clang4edit12EditedSource8FileEditC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZN5clang4edit12EditedSource8FileEditC1Ev")
    //</editor-fold>
    public FileEdit() {
      // : Text(), RemoveLen(0) 
      //START JInit
      this.Text = new StringRef();
      this.RemoveLen = 0;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::edit::EditedSource::FileEdit::FileEdit">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/EditedSource.h", line = 34,
     FQN="clang::edit::EditedSource::FileEdit::FileEdit", NM="_ZN5clang4edit12EditedSource8FileEditC1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZN5clang4edit12EditedSource8FileEditC1ERKS2_")
    //</editor-fold>
    public /*inline*/ FileEdit(/*const*/ FileEdit /*&*/ $Prm0) {
      // : Text(.Text), RemoveLen(.RemoveLen) 
      //START JInit
      this.Text = new StringRef($Prm0.Text);
      this.RemoveLen = $Prm0.RemoveLen;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::edit::EditedSource::FileEdit::FileEdit">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/EditedSource.h", line = 34,
     FQN="clang::edit::EditedSource::FileEdit::FileEdit", NM="_ZN5clang4edit12EditedSource8FileEditC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZN5clang4edit12EditedSource8FileEditC1EOS2_")
    //</editor-fold>
    public /*inline*/ FileEdit(JD$Move _dparam, FileEdit /*&&*/$Prm0) {
      // : Text(static_cast<FileEdit &&>().Text), RemoveLen(static_cast<FileEdit &&>().RemoveLen) 
      //START JInit
      this.Text = new StringRef(JD$Move.INSTANCE, $Prm0.Text);
      this.RemoveLen = $Prm0.RemoveLen;
      //END JInit
    }

    @Override public FileEdit clone() { return new FileEdit(this); }
    
    @Override public String toString() {
      return "" + "Text=" + Text // NOI18N
                + ", RemoveLen=" + RemoveLen; // NOI18N
    }
  };
  
  /*typedef std::map<FileOffset, FileEdit> FileEditsTy*/
//  public final class FileEditsTy extends std.map<FileOffset, FileEdit>{ };
  private std.mapTypeType<FileOffset, FileEdit> FileEdits;
  
  private DenseMapUIntType<TinyPtrVector<IdentifierInfo /*P*/ >> ExpansionToArgMap;
  private SmallVector<std.pair<SourceLocation, IdentifierInfo /*P*/ >> CurrCommitMacroArgExps;
  
  private IdentifierTable IdentTable;
  private BumpPtrAllocatorImpl StrAlloc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::edit::EditedSource::EditedSource">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/EditedSource.h", line = 53,
   FQN="clang::edit::EditedSource::EditedSource", NM="_ZN5clang4edit12EditedSourceC1ERKNS_13SourceManagerERKNS_11LangOptionsEPKNS_28PPConditionalDirectiveRecordE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZN5clang4edit12EditedSourceC1ERKNS_13SourceManagerERKNS_11LangOptionsEPKNS_28PPConditionalDirectiveRecordE")
  //</editor-fold>
  public EditedSource(/*const*/ SourceManager /*&*/ SM, /*const*/ LangOptions /*&*/ LangOpts) {
    this(SM, LangOpts, 
      (/*const*/ PPConditionalDirectiveRecord /*P*/ )null);
  }
  public EditedSource(/*const*/ SourceManager /*&*/ SM, /*const*/ LangOptions /*&*/ LangOpts, 
      /*const*/ PPConditionalDirectiveRecord /*P*/ PPRec/*= null*/) {
    // : SourceMgr(SM), LangOpts(LangOpts), PPRec(PPRec), FileEdits(), ExpansionToArgMap(), CurrCommitMacroArgExps(), IdentTable(LangOpts), StrAlloc() 
    //START JInit
    this./*&*/SourceMgr=/*&*/SM;
    this./*&*/LangOpts=/*&*/LangOpts;
    this.PPRec = PPRec;
    this.FileEdits = new std.mapTypeType<FileOffset, FileEdit>(new FileEdit());
    this.ExpansionToArgMap = new DenseMapUIntType<TinyPtrVector<IdentifierInfo /*P*/ >>(DenseMapInfoUInt.$Info(), new TinyPtrVector<IdentifierInfo /*P*/ >());
    this.CurrCommitMacroArgExps = new SmallVector<std.pair<SourceLocation, IdentifierInfo /*P*/ >>(2, new std.pairTypePtr<SourceLocation, IdentifierInfo /*P*/ >(new SourceLocation(), null));
    this.IdentTable = new IdentifierTable(LangOpts);
    this.StrAlloc = new BumpPtrAllocatorImpl();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::edit::EditedSource::getSourceManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/EditedSource.h", line = 58,
   FQN="clang::edit::EditedSource::getSourceManager", NM="_ZNK5clang4edit12EditedSource16getSourceManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZNK5clang4edit12EditedSource16getSourceManagerEv")
  //</editor-fold>
  public /*const*/ SourceManager /*&*/ getSourceManager() /*const*/ {
    return SourceMgr;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::EditedSource::getLangOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/EditedSource.h", line = 59,
   FQN="clang::edit::EditedSource::getLangOpts", NM="_ZNK5clang4edit12EditedSource11getLangOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZNK5clang4edit12EditedSource11getLangOptsEv")
  //</editor-fold>
  public /*const*/ LangOptions /*&*/ getLangOpts() /*const*/ {
    return LangOpts;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::EditedSource::getPPCondDirectiveRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/EditedSource.h", line = 60,
   FQN="clang::edit::EditedSource::getPPCondDirectiveRecord", NM="_ZNK5clang4edit12EditedSource24getPPCondDirectiveRecordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZNK5clang4edit12EditedSource24getPPCondDirectiveRecordEv")
  //</editor-fold>
  public /*const*/ PPConditionalDirectiveRecord /*P*/ getPPCondDirectiveRecord() /*const*/ {
    return PPRec;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::edit::EditedSource::canInsertInOffset">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp", line = 61,
   FQN="clang::edit::EditedSource::canInsertInOffset", NM="_ZN5clang4edit12EditedSource17canInsertInOffsetENS_14SourceLocationENS0_10FileOffsetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZN5clang4edit12EditedSource17canInsertInOffsetENS_14SourceLocationENS0_10FileOffsetE")
  //</editor-fold>
  public boolean canInsertInOffset(SourceLocation OrigLoc, FileOffset Offs) {
    std.mapTypeType.iterator</*const*/ FileOffset, FileEdit> FA = getActionForOffset(new FileOffset(Offs));
    if (FA.$noteq(FileEdits.end())) {
      if ($noteq_FileOffset(/*NO_COPY*/FA.$arrow().first, /*NO_COPY*/Offs)) {
        return false; // position has been removed.
      }
    }
    if (SourceMgr.isMacroArgExpansion(/*NO_COPY*/OrigLoc)) {
      type$ref<IdentifierInfo> /*P*/ II = create_type$ref(null);
      SourceLocation ExpLoc/*J*/= new SourceLocation();
      deconstructMacroArgLoc(new SourceLocation(OrigLoc), ExpLoc, II);
      DenseMapIteratorUIntType<TinyPtrVector<IdentifierInfo>> I = ExpansionToArgMap.find(ExpLoc.getRawEncoding());
      if (I.$noteq(/*NO_ITER_COPY*/ExpansionToArgMap.end())
         && std.find(I.$arrow().second.begin(), I.$arrow().second.end(), II.$deref(), true).$noteq(I.$arrow().second.end())) {
        // Trying to write in a macro argument input that has already been
        // written by a previous commit for another expansion of the same macro
        // argument name. For example:
        //
        // \code
        //   #define MAC(x) ((x)+(x))
        //   MAC(a)
        // \endcode
        //
        // A commit modified the macro argument 'a' due to the first '(x)'
        // expansion inside the macro definition, and a subsequent commit tried
        // to modify 'a' again for the second '(x)' expansion. The edits of the
        // second commit will be rejected.
        return false;
      }
    }
    
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="CommitRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp", line = 264,
   FQN="CommitRAII", NM="_ZZN5clang4edit12EditedSource6commitERKNS0_6CommitEE10CommitRAII",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZZN5clang4edit12EditedSource6commitERKNS0_6CommitEE10CommitRAII")
  //</editor-fold>
  private static final class/*struct*/ CommitRAII implements Destructors.ClassWithDestructor {
    public EditedSource /*&*/ Editor;
    //<editor-fold defaultstate="collapsed" desc="clang::edit::EditedSource::commit(const Commit & )::CommitRAII::CommitRAII">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp", line = 266,
     FQN="clang::edit::EditedSource::commit(const Commit & )::CommitRAII::CommitRAII", NM="_ZZN5clang4edit12EditedSource6commitERKNS0_6CommitEEN10CommitRAIIC1ERS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZZN5clang4edit12EditedSource6commitERKNS0_6CommitEEN10CommitRAIIC1ERS1_")
    //</editor-fold>
    public CommitRAII(EditedSource /*&*/ Editor) {
      // : Editor(Editor) 
      //START JInit
      this./*&*/Editor=/*&*/Editor;
      //END JInit
      Editor.startingCommit();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::edit::EditedSource::commit(const Commit & )::CommitRAII::~CommitRAII">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp", line = 269,
     FQN="clang::edit::EditedSource::commit(const Commit & )::CommitRAII::~CommitRAII", NM="_ZZN5clang4edit12EditedSource6commitERKNS0_6CommitEEN10CommitRAIID0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZZN5clang4edit12EditedSource6commitERKNS0_6CommitEEN10CommitRAIID0Ev")
    //</editor-fold>
    public void $destroy() {
      Editor.finishedCommit();
    }


    @Override public String toString() {
      return "" + "Editor=" + Editor; // NOI18N
    }
  }
      
  //<editor-fold defaultstate="collapsed" desc="clang::edit::EditedSource::commit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp", line = 260,
   FQN="clang::edit::EditedSource::commit", NM="_ZN5clang4edit12EditedSource6commitERKNS0_6CommitE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZN5clang4edit12EditedSource6commitERKNS0_6CommitE")
  //</editor-fold>
  public boolean commit(/*const*/ Commit /*&*/ commit) {
    CommitRAII CommitRAII = null;
    try {
      if (!commit.isCommitable()) {
        return false;
      }
      
      CommitRAII/*J*/= new CommitRAII(/*Deref*/this);
      
      for (type$ptr<Edit> I = commit.edit_begin(), E = commit.edit_end(); I.$noteq(E); I.$preInc()) {
        /*const*/ Commit.Edit /*&*/ edit = /*Deref*/I.$star();
        switch (edit.Kind) {
         case Act_Insert:
          commitInsert(new SourceLocation(edit.OrigLoc), new FileOffset(edit.Offset), new StringRef(edit.Text), edit.BeforePrev);
          break;
         case Act_InsertFromRange:
          commitInsertFromRange(new SourceLocation(edit.OrigLoc), new FileOffset(edit.Offset), 
              new FileOffset(edit.InsertFromRangeOffs), edit.Length, 
              edit.BeforePrev);
          break;
         case Act_Remove:
          commitRemove(new SourceLocation(edit.OrigLoc), new FileOffset(edit.Offset), edit.Length);
          break;
        }
      }
      
      return true;
    } finally {
      if (CommitRAII != null) { CommitRAII.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::edit::EditedSource::applyRewrites">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp", line = 390,
   FQN="clang::edit::EditedSource::applyRewrites", NM="_ZN5clang4edit12EditedSource13applyRewritesERNS0_13EditsReceiverE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZN5clang4edit12EditedSource13applyRewritesERNS0_13EditsReceiverE")
  //</editor-fold>
  public void applyRewrites(EditsReceiver /*&*/ receiver) {
    SmallString/*128*/ StrVec/*J*/= new SmallString/*128*/(128);
    FileOffset CurOffs/*J*/= new FileOffset(), CurEnd/*J*/= new FileOffset();
    /*uint*/int CurLen;
    if (FileEdits.empty()) {
      return;
    }
    
    std.mapTypeType.iterator</*const*/ FileOffset, FileEdit> I = FileEdits.begin();
    CurOffs.$assign(I.$arrow().first);
    StrVec.$assign(/*NO_COPY*/I.$arrow().second.Text);
    CurLen = I.$arrow().second.RemoveLen;
    CurEnd.$assignMove(CurOffs.getWithOffset(CurLen));
    I.$preInc();
    
    for (std.mapTypeType.iterator</*const*/ FileOffset, FileEdit> E = FileEdits.end(); I.$noteq(E); I.$preInc()) {
      FileOffset offs = new FileOffset(I.$arrow().first);
      FileEdit act = new FileEdit(I.$arrow().second);
      assert ($greatereq_FileOffset(/*NO_COPY*/offs, /*NO_COPY*/CurEnd));
      if ($eq_FileOffset(/*NO_COPY*/offs, /*NO_COPY*/CurEnd)) {
        StrVec.$addassign(/*NO_COPY*/act.Text);
        CurLen += act.RemoveLen;
        CurEnd.getWithOffset(act.RemoveLen);
        continue;
      }
      
      applyRewrite(receiver, StrVec.$StringRef(), new FileOffset(CurOffs), CurLen, SourceMgr, LangOpts);
      CurOffs.$assign(offs);
      StrVec.$assign(/*NO_COPY*/act.Text);
      CurLen = act.RemoveLen;
      CurEnd.$assignMove(CurOffs.getWithOffset(CurLen));
    }
    
    applyRewrite(receiver, StrVec.$StringRef(), new FileOffset(CurOffs), CurLen, SourceMgr, LangOpts);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::EditedSource::clearRewrites">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp", line = 427,
   FQN="clang::edit::EditedSource::clearRewrites", NM="_ZN5clang4edit12EditedSource13clearRewritesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZN5clang4edit12EditedSource13clearRewritesEv")
  //</editor-fold>
  public void clearRewrites() {
    FileEdits.clear();
    StrAlloc.Reset();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::edit::EditedSource::copyString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/EditedSource.h", line = 71,
   FQN="clang::edit::EditedSource::copyString", NM="_ZN5clang4edit12EditedSource10copyStringEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZN5clang4edit12EditedSource10copyStringEN4llvm9StringRefE")
  //</editor-fold>
  public StringRef copyString(StringRef str) {
    return str.copy(StrAlloc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::EditedSource::copyString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp", line = 56,
   FQN="clang::edit::EditedSource::copyString", NM="_ZN5clang4edit12EditedSource10copyStringERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZN5clang4edit12EditedSource10copyStringERKN4llvm5TwineE")
  //</editor-fold>
  public StringRef copyString(/*const*/ Twine /*&*/ twine) {
    SmallString/*128*/ Data/*J*/= new SmallString/*128*/(128);
    return copyString(twine.toStringRef(Data));
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::edit::EditedSource::commitInsert">
  @Converted(kind = Converted.Kind.MANUAL/*emplace back Clone*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp", line = 95,
   FQN="clang::edit::EditedSource::commitInsert", NM="_ZN5clang4edit12EditedSource12commitInsertENS_14SourceLocationENS0_10FileOffsetEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZN5clang4edit12EditedSource12commitInsertENS_14SourceLocationENS0_10FileOffsetEN4llvm9StringRefEb")
  //</editor-fold>
  private boolean commitInsert(SourceLocation OrigLoc, 
              FileOffset Offs, StringRef text, 
              boolean beforePreviousInsertions) {
    if (!canInsertInOffset(new SourceLocation(OrigLoc), new FileOffset(Offs))) {
      return false;
    }
    if (text.empty()) {
      return true;
    }
    if (SourceMgr.isMacroArgExpansion(/*NO_COPY*/OrigLoc)) {
      type$ref<IdentifierInfo> /*P*/ II = create_type$ref(null);
      SourceLocation ExpLoc/*J*/= new SourceLocation();
      deconstructMacroArgLoc(new SourceLocation(OrigLoc), ExpLoc, II);
      if ((II.$deref() != null)) {
        CurrCommitMacroArgExps.emplace_back(new std.pairTypePtr<SourceLocation, IdentifierInfo /*P*/ >(Native.$Clone(ExpLoc), II.$deref()));
      }
    }
    
    FileEdit /*&*/ FA = FileEdits.$at_T$C$R(Offs);
    if (FA.Text.empty()) {
      FA.Text.$assignMove(copyString(new StringRef(text)));
      return true;
    }
    if (beforePreviousInsertions) {
      FA.Text.$assignMove(copyString($add_Twine$C(new Twine(text), new Twine(FA.Text))));
    } else {
      FA.Text.$assignMove(copyString($add_Twine$C(new Twine(FA.Text), new Twine(text))));
    }
    
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::EditedSource::commitInsertFromRange">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp", line = 125,
   FQN="clang::edit::EditedSource::commitInsertFromRange", NM="_ZN5clang4edit12EditedSource21commitInsertFromRangeENS_14SourceLocationENS0_10FileOffsetES3_jb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZN5clang4edit12EditedSource21commitInsertFromRangeENS_14SourceLocationENS0_10FileOffsetES3_jb")
  //</editor-fold>
  private boolean commitInsertFromRange(SourceLocation OrigLoc, 
                       FileOffset Offs, 
                       FileOffset InsertFromRangeOffs, /*uint*/int Len, 
                       boolean beforePreviousInsertions) {
    if (Len == 0) {
      return true;
    }
    
    SmallString/*128*/ StrVec/*J*/= new SmallString/*128*/(128);
    FileOffset BeginOffs = new FileOffset(InsertFromRangeOffs);
    FileOffset EndOffs = BeginOffs.getWithOffset(Len);
    std.mapTypeType.iterator</*const*/ FileOffset, FileEdit> I = FileEdits.upper_bound(BeginOffs);
    if (I.$noteq(FileEdits.begin())) {
      I.$preDec();
    }
    
    for (; I.$noteq(FileEdits.end()); I.$preInc()) {
      FileEdit /*&*/ FA = I.$arrow().second;
      FileOffset B = new FileOffset(I.$arrow().first);
      FileOffset E = B.getWithOffset(FA.RemoveLen);
      if ($eq_FileOffset(/*NO_COPY*/BeginOffs, /*NO_COPY*/B)) {
        break;
      }
      if ($less_FileOffset(/*NO_COPY*/BeginOffs, /*NO_COPY*/E)) {
        if ($greater_FileOffset(/*NO_COPY*/BeginOffs, /*NO_COPY*/B)) {
          BeginOffs.$assign(E);
          I.$preInc();
        }
        break;
      }
    }
    
    for (; I.$noteq(FileEdits.end()) && $greater_FileOffset(/*NO_COPY*/EndOffs, /*NO_COPY*/I.$arrow().first); I.$preInc()) {
      FileEdit /*&*/ FA = I.$arrow().second;
      FileOffset B = new FileOffset(I.$arrow().first);
      FileOffset E = B.getWithOffset(FA.RemoveLen);
      if ($less_FileOffset(/*NO_COPY*/BeginOffs, /*NO_COPY*/B)) {
        bool$ref Invalid = create_bool$ref(false);
        StringRef text = getSourceText(new FileOffset(BeginOffs), new FileOffset(B), Invalid);
        if (Invalid.$deref()) {
          return false;
        }
        StrVec.$addassign(/*NO_COPY*/text);
      }
      StrVec.$addassign(/*NO_COPY*/FA.Text);
      BeginOffs.$assign(E);
    }
    if ($less_FileOffset(/*NO_COPY*/BeginOffs, /*NO_COPY*/EndOffs)) {
      bool$ref Invalid = create_bool$ref(false);
      StringRef text = getSourceText(new FileOffset(BeginOffs), new FileOffset(EndOffs), Invalid);
      if (Invalid.$deref()) {
        return false;
      }
      StrVec.$addassign(/*NO_COPY*/text);
    }
    
    return commitInsert(new SourceLocation(OrigLoc), new FileOffset(Offs), StrVec.$StringRef(), beforePreviousInsertions);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::EditedSource::commitRemove">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp", line = 183,
   FQN="clang::edit::EditedSource::commitRemove", NM="_ZN5clang4edit12EditedSource12commitRemoveENS_14SourceLocationENS0_10FileOffsetEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZN5clang4edit12EditedSource12commitRemoveENS_14SourceLocationENS0_10FileOffsetEj")
  //</editor-fold>
  private void commitRemove(SourceLocation OrigLoc, 
              FileOffset BeginOffs, /*uint*/int Len) {
    if (Len == 0) {
      return;
    }
    
    FileOffset EndOffs = BeginOffs.getWithOffset(Len);
    std.mapTypeType.iterator</*const*/ FileOffset, FileEdit> I = FileEdits.upper_bound(BeginOffs);
    if (I.$noteq(FileEdits.begin())) {
      I.$preDec();
    }
    
    for (; I.$noteq(FileEdits.end()); I.$preInc()) {
      FileEdit /*&*/ FA = I.$arrow().second;
      FileOffset B = new FileOffset(I.$arrow().first);
      FileOffset E = B.getWithOffset(FA.RemoveLen);
      if ($less_FileOffset(/*NO_COPY*/BeginOffs, /*NO_COPY*/E)) {
        break;
      }
    }
    
    FileOffset TopBegin/*J*/= new FileOffset(), TopEnd/*J*/= new FileOffset();
    FileEdit /*P*/ TopFA = null;
    if (I.$eq(FileEdits.end())) {
      // JAVA:
      std.mapTypeType.iterator</*const*/ FileOffset, FileEdit> NewI = FileEdits.insert(/*I, */std.make_pair(BeginOffs, new FileEdit())).first;
      NewI.$arrow().second.RemoveLen = Len;
      return;
    }
    
    FileEdit /*&*/ FA = I.$arrow().second;
    FileOffset B = new FileOffset(I.$arrow().first);
    FileOffset E = B.getWithOffset(FA.RemoveLen);
    if ($less_FileOffset(/*NO_COPY*/BeginOffs, /*NO_COPY*/B)) {
      // JAVA:
      std.mapTypeType.iterator</*const*/ FileOffset, FileEdit> NewI = FileEdits.insert(/*I, */std.make_pair(BeginOffs, new FileEdit())).first;
      TopBegin.$assign(BeginOffs);
      TopEnd.$assign(EndOffs);
      TopFA = /*AddrOf*/NewI.$arrow().second;
      TopFA.RemoveLen = Len;
    } else {
      TopBegin.$assign(B);
      TopEnd.$assign(E);
      TopFA = /*AddrOf*/I.$arrow().second;
      if ($greatereq_FileOffset(/*NO_COPY*/TopEnd, /*NO_COPY*/EndOffs)) {
        return;
      }
      /*uint*/int diff = EndOffs.getOffset() - TopEnd.getOffset();
      TopEnd.$assign(EndOffs);
      TopFA.RemoveLen += diff;
      if ($eq_FileOffset(/*NO_COPY*/B, /*NO_COPY*/BeginOffs)) {
        TopFA.Text.$assignMove(new StringRef());
      }
      I.$preInc();
    }
    while (I.$noteq(FileEdits.end())) {
      FileEdit /*&*/ _FA = I.$arrow().second;
      FileOffset _B = new FileOffset(I.$arrow().first);
      FileOffset _E = _B.getWithOffset(_FA.RemoveLen);
      if ($greatereq_FileOffset(/*NO_COPY*/_B, /*NO_COPY*/TopEnd)) {
        break;
      }
      if ($lesseq_FileOffset(/*NO_COPY*/_E, /*NO_COPY*/TopEnd)) {
        FileEdits.erase(I.$postInc());
        continue;
      }
      if ($less_FileOffset(/*NO_COPY*/_B, /*NO_COPY*/TopEnd)) {
        /*uint*/int diff = _E.getOffset() - TopEnd.getOffset();
        TopEnd.$assign(_E);
        TopFA.RemoveLen += diff;
        FileEdits.erase(I);
      }
      
      break;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::edit::EditedSource::getSourceText">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp", line = 432,
   FQN="clang::edit::EditedSource::getSourceText", NM="_ZN5clang4edit12EditedSource13getSourceTextENS0_10FileOffsetES2_Rb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZN5clang4edit12EditedSource13getSourceTextENS0_10FileOffsetES2_Rb")
  //</editor-fold>
  private StringRef getSourceText(FileOffset BeginOffs, FileOffset EndOffs, 
               bool$ref/*bool &*/ Invalid) {
    assert (BeginOffs.getFID().$eq(EndOffs.getFID()));
    assert ($lesseq_FileOffset(/*NO_COPY*/BeginOffs, /*NO_COPY*/EndOffs));
    SourceLocation BLoc = SourceMgr.getLocForStartOfFile(BeginOffs.getFID());
    BLoc.$assignMove(BLoc.getLocWithOffset(BeginOffs.getOffset()));
    assert (BLoc.isFileID());
    SourceLocation ELoc = BLoc.getLocWithOffset(EndOffs.getOffset() - BeginOffs.getOffset());
    return Lexer.getSourceText(CharSourceRange.getCharRange(/*NO_COPY*/BLoc, /*NO_COPY*/ELoc), 
        SourceMgr, LangOpts, Invalid.deref$ptr());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::EditedSource::getActionForOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp", line = 445,
   FQN="clang::edit::EditedSource::getActionForOffset", NM="_ZN5clang4edit12EditedSource18getActionForOffsetENS0_10FileOffsetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZN5clang4edit12EditedSource18getActionForOffsetENS0_10FileOffsetE")
  //</editor-fold>
  private std.mapTypeType.iterator</*const*/ FileOffset, FileEdit> getActionForOffset(FileOffset Offs) {
    std.mapTypeType.iterator</*const*/ FileOffset, FileEdit> I = FileEdits.upper_bound(Offs);
    if (I.$eq(FileEdits.begin())) {
      return FileEdits.end();
    }
    I.$preDec();
    FileEdit /*&*/ FA = I.$arrow().second;
    FileOffset B = new FileOffset(I.$arrow().first);
    FileOffset E = B.getWithOffset(FA.RemoveLen);
    if ($greatereq_FileOffset(/*NO_COPY*/Offs, /*NO_COPY*/B) && $less_FileOffset(/*NO_COPY*/Offs, /*NO_COPY*/E)) {
      return I;
    }
    
    return FileEdits.end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::EditedSource::deconstructMacroArgLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp", line = 26,
   FQN="clang::edit::EditedSource::deconstructMacroArgLoc", NM="_ZN5clang4edit12EditedSource22deconstructMacroArgLocENS_14SourceLocationERS2_RPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZN5clang4edit12EditedSource22deconstructMacroArgLocENS_14SourceLocationERS2_RPNS_14IdentifierInfoE")
  //</editor-fold>
  private void deconstructMacroArgLoc(SourceLocation Loc, 
                        SourceLocation /*&*/ ExpansionLoc, 
                        type$ref<IdentifierInfo> II) {
    assert (SourceMgr.isMacroArgExpansion(/*NO_COPY*/Loc));
    SourceLocation DefArgLoc = new SourceLocation(JD$Move.INSTANCE, SourceMgr.getImmediateExpansionRange(/*NO_COPY*/Loc).first);
    ExpansionLoc.$assignMove(SourceMgr.getImmediateExpansionRange(/*NO_COPY*/DefArgLoc).first);
    SmallString/*20*/ Buf/*J*/= new SmallString/*20*/(20);
    StringRef ArgName = Lexer.getSpelling(SourceMgr.getSpellingLoc(/*NO_COPY*/DefArgLoc), 
        Buf, SourceMgr, LangOpts);
    II.$set(null);
    if (!ArgName.empty()) {
      char$ptr $data = ArgName.data();
      II.$set(/*AddrOf*/IdentTable.get(/*NO_COPY*/$data.$array(), $data.$index(), ArgName.size()));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::edit::EditedSource::startingCommit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp", line = 41,
   FQN="clang::edit::EditedSource::startingCommit", NM="_ZN5clang4edit12EditedSource14startingCommitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZN5clang4edit12EditedSource14startingCommitEv")
  //</editor-fold>
  private void startingCommit() {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::EditedSource::finishedCommit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp", line = 43,
   FQN="clang::edit::EditedSource::finishedCommit", NM="_ZN5clang4edit12EditedSource14finishedCommitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZN5clang4edit12EditedSource14finishedCommitEv")
  //</editor-fold>
  private void finishedCommit() {
    for (pair<SourceLocation, IdentifierInfo /*P*/ > /*&*/ ExpArg : CurrCommitMacroArgExps) {
      SourceLocation ExpLoc/*J*/= new SourceLocation(ExpArg.first);
      IdentifierInfo /*P*/ II = ExpArg.second;
//      std.tie(ExpLoc, II).$assign_pair$_U1$_U2$C(ExpArg);
      TinyPtrVector<IdentifierInfo /*P*/ > /*&*/ ArgNames = ExpansionToArgMap.$at_T1$RR(ExpLoc.getRawEncoding());
      if (std.find(ArgNames.begin(), ArgNames.end(), II, true).$eq(ArgNames.end())) {
        ArgNames.push_back(II);
      }
    }
    CurrCommitMacroArgExps.clear();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::EditedSource::~EditedSource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/EditedSource.h", line = 29,
   FQN="clang::edit::EditedSource::~EditedSource", NM="_ZN5clang4edit12EditedSourceD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang4edit12EditedSourceD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    StrAlloc.$destroy();
    IdentTable.$destroy();
    CurrCommitMacroArgExps.$destroy();
    ExpansionToArgMap.$destroy();
    FileEdits.$destroy();
    //END JDestroy
  }


  
  @Override public String toString() {
    return "" + "SourceMgr=" + SourceMgr // NOI18N
              + ", LangOpts=" + LangOpts // NOI18N
              + ", PPRec=" + PPRec // NOI18N
              + ", FileEdits=" + FileEdits // NOI18N
              + ", ExpansionToArgMap=" + ExpansionToArgMap // NOI18N
              + ", CurrCommitMacroArgExps=" + CurrCommitMacroArgExps // NOI18N
              + ", IdentTable=" + IdentTable // NOI18N
              + ", StrAlloc=" + StrAlloc; // NOI18N
  }
}
