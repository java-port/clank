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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.edit.*;
import static org.clang.edit.FileOffset.*;
import org.clang.lex.*;

//<editor-fold defaultstate="collapsed" desc="clang::edit::Commit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/Commit.h", line = 25,
 FQN="clang::edit::Commit", NM="_ZN5clang4edit6CommitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit6CommitE")
//</editor-fold>
public class Commit implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::EditKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/Commit.h", line = 27,
   FQN="clang::edit::Commit::EditKind", NM="_ZN5clang4edit6Commit8EditKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit6Commit8EditKindE")
  //</editor-fold>
  public enum EditKind implements Native.ComparableLower {
    Act_Insert(0),
    Act_InsertFromRange(Act_Insert.getValue() + 1),
    Act_Remove(Act_InsertFromRange.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static EditKind valueOf(int val) {
      EditKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final EditKind[] VALUES;
      private static final EditKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (EditKind kind : EditKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new EditKind[min < 0 ? (1-min) : 0];
        VALUES = new EditKind[max >= 0 ? (1+max) : 0];
        for (EditKind kind : EditKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private EditKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((EditKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((EditKind)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::Edit">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*NativePOD*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/Commit.h", line = 33,
   FQN="clang::edit::Commit::Edit", NM="_ZN5clang4edit6Commit4EditE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit6Commit4EditE")
  //</editor-fold>
  public static class/*struct*/ Edit implements Native.NativePOD<Edit> {
    public EditKind Kind;
    public StringRef Text;
    public SourceLocation OrigLoc;
    public FileOffset Offset;
    public FileOffset InsertFromRangeOffs;
    public /*uint*/int Length;
    public boolean BeforePrev;
    
    //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::Edit::getFileLocation">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp", line = 19,
     FQN="clang::edit::Commit::Edit::getFileLocation", NM="_ZNK5clang4edit6Commit4Edit15getFileLocationERNS_13SourceManagerE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZNK5clang4edit6Commit4Edit15getFileLocationERNS_13SourceManagerE")
    //</editor-fold>
    public SourceLocation getFileLocation(SourceManager /*&*/ SM) /*const*/ {
      SourceLocation Loc = SM.getLocForStartOfFile(Offset.getFID());
      Loc.$assignMove(Loc.getLocWithOffset(Offset.getOffset()));
      assert (Loc.isFileID());
      return Loc;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::Edit::getFileRange">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp", line = 26,
     FQN="clang::edit::Commit::Edit::getFileRange", NM="_ZNK5clang4edit6Commit4Edit12getFileRangeERNS_13SourceManagerE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZNK5clang4edit6Commit4Edit12getFileRangeERNS_13SourceManagerE")
    //</editor-fold>
    public CharSourceRange getFileRange(SourceManager /*&*/ SM) /*const*/ {
      SourceLocation Loc = getFileLocation(SM);
      return CharSourceRange.getCharRange(/*NO_COPY*/Loc, Loc.getLocWithOffset(Length));
    }

    //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::Edit::getInsertFromRange">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp", line = 31,
     FQN="clang::edit::Commit::Edit::getInsertFromRange", NM="_ZNK5clang4edit6Commit4Edit18getInsertFromRangeERNS_13SourceManagerE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZNK5clang4edit6Commit4Edit18getInsertFromRangeERNS_13SourceManagerE")
    //</editor-fold>
    public CharSourceRange getInsertFromRange(SourceManager /*&*/ SM) /*const*/ {
      SourceLocation Loc = SM.getLocForStartOfFile(InsertFromRangeOffs.getFID());
      Loc.$assignMove(Loc.getLocWithOffset(InsertFromRangeOffs.getOffset()));
      assert (Loc.isFileID());
      return CharSourceRange.getCharRange(/*NO_COPY*/Loc, Loc.getLocWithOffset(Length));
    }

    //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::Edit::Edit">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/Commit.h", line = 33,
     FQN="clang::edit::Commit::Edit::Edit", NM="_ZN5clang4edit6Commit4EditC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit6Commit4EditC1Ev")
    //</editor-fold>
    public /*inline*/ Edit() {
      // : Text(), OrigLoc(), Offset(), InsertFromRangeOffs() 
      //START JInit
      this.Text = new StringRef();
      this.OrigLoc = new SourceLocation();
      this.Offset = new FileOffset();
      this.InsertFromRangeOffs = new FileOffset();
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "Kind=" + Kind // NOI18N
                + ", Text=" + Text // NOI18N
                + ", OrigLoc=" + OrigLoc // NOI18N
                + ", Offset=" + Offset // NOI18N
                + ", InsertFromRangeOffs=" + InsertFromRangeOffs // NOI18N
                + ", Length=" + Length // NOI18N
                + ", BeforePrev=" + BeforePrev; // NOI18N
    }

    @Override
    public Edit $assign(Edit other) {
      this.Kind = other.Kind;
      this.Text = other.Text;
      this.OrigLoc.$assign(other.OrigLoc);
      this.Offset.$assign(other.Offset);
      this.InsertFromRangeOffs.$assign(other.InsertFromRangeOffs);
      this.Length = other.Length;
      this.BeforePrev = other.BeforePrev;
      return this;
    }

    public Edit(Edit other) {
      this.Kind = other.Kind;
      this.Text = new StringRef(other.Text);
      this.OrigLoc = new SourceLocation(other.OrigLoc);
      this.Offset = new FileOffset(other.Offset);
      this.InsertFromRangeOffs = new FileOffset(other.InsertFromRangeOffs);
      this.Length = other.Length;
      this.BeforePrev = other.BeforePrev;
    }
    
    @Override
    public Edit clone() {
      return new Edit(this);
    }

    @Override
    public boolean $eq(Edit other) {
      if (this.Length != other.Length) {
        return false;
      }
      if (this.BeforePrev != other.BeforePrev) {
        return false;
      }
      if (this.Kind != other.Kind) {
        return false;
      }
      if (!this.Text.$eq(other.Text)) {
        return false;
      }
      if (!this.OrigLoc.$eq(other.OrigLoc)) {
        return false;
      }
      if (!this.Offset.$eq(other.Offset)) {
        return false;
      }
      return this.InsertFromRangeOffs.$eq(other.InsertFromRangeOffs);
    }
    
    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null) {
        return false;
      }
      if (getClass() != obj.getClass()) {
        return false;
      }
      return $eq((Edit) obj);
    }
  };
  
/*private:*/
  private /*const*/ SourceManager /*&*/ SourceMgr;
  private /*const*/ LangOptions /*&*/ LangOpts;
  private /*const*/ PPConditionalDirectiveRecord /*P*/ PPRec;
  private EditedSource /*P*/ Editor;
  
  private boolean IsCommitable;
  private SmallVector<Edit> CachedEdits;
  
  private BumpPtrAllocatorImpl StrAlloc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::Commit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp", line = 38,
   FQN="clang::edit::Commit::Commit", NM="_ZN5clang4edit6CommitC1ERNS0_12EditedSourceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit6CommitC1ERNS0_12EditedSourceE")
  //</editor-fold>
  public Commit(EditedSource /*&*/ Editor) {
    // : SourceMgr(Editor.getSourceManager()), LangOpts(Editor.getLangOpts()), PPRec(Editor.getPPCondDirectiveRecord()), Editor(&Editor), IsCommitable(true), CachedEdits(), StrAlloc() 
    //START JInit
    this./*&*/SourceMgr=/*&*/Editor.getSourceManager();
    this./*&*/LangOpts=/*&*/Editor.getLangOpts();
    this.PPRec = Editor.getPPCondDirectiveRecord();
    this.Editor = /*AddrOf*/Editor;
    this.IsCommitable = true;
    this.CachedEdits = new SmallVector<Edit>(8, new Edit());
    this.StrAlloc = new BumpPtrAllocatorImpl();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::Commit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/Commit.h", line = 60,
   FQN="clang::edit::Commit::Commit", NM="_ZN5clang4edit6CommitC1ERKNS_13SourceManagerERKNS_11LangOptionsEPKNS_28PPConditionalDirectiveRecordE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit6CommitC1ERKNS_13SourceManagerERKNS_11LangOptionsEPKNS_28PPConditionalDirectiveRecordE")
  //</editor-fold>
  public Commit(/*const*/ SourceManager /*&*/ SM, /*const*/ LangOptions /*&*/ LangOpts) {
    this(SM, LangOpts, 
      (/*const*/ PPConditionalDirectiveRecord /*P*/ )null);
  }
  public Commit(/*const*/ SourceManager /*&*/ SM, /*const*/ LangOptions /*&*/ LangOpts, 
      /*const*/ PPConditionalDirectiveRecord /*P*/ PPRec/*= null*/) {
    // : SourceMgr(SM), LangOpts(LangOpts), PPRec(PPRec), Editor(null), IsCommitable(true), CachedEdits(), StrAlloc() 
    //START JInit
    this./*&*/SourceMgr=/*&*/SM;
    this./*&*/LangOpts=/*&*/LangOpts;
    this.PPRec = PPRec;
    this.Editor = null;
    this.IsCommitable = true;
    this.CachedEdits = new SmallVector<Edit>(8, new Edit());
    this.StrAlloc = new BumpPtrAllocatorImpl();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::isCommitable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/Commit.h", line = 65,
   FQN="clang::edit::Commit::isCommitable", NM="_ZNK5clang4edit6Commit12isCommitableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZNK5clang4edit6Commit12isCommitableEv")
  //</editor-fold>
  public boolean isCommitable() /*const*/ {
    return IsCommitable;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::insert">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp", line = 43,
   FQN="clang::edit::Commit::insert", NM="_ZN5clang4edit6Commit6insertENS_14SourceLocationEN4llvm9StringRefEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit6Commit6insertENS_14SourceLocationEN4llvm9StringRefEbb")
  //</editor-fold>
  public boolean insert(SourceLocation loc, StringRef text) {
    return insert(loc, text, 
        false, false);
  }
  public boolean insert(SourceLocation loc, StringRef text, 
        boolean afterToken/*= false*/) {
    return insert(loc, text, 
        afterToken, false);
  }
  public boolean insert(SourceLocation loc, StringRef text, 
        boolean afterToken/*= false*/, boolean beforePreviousInsertions/*= false*/) {
    if (text.empty()) {
      return true;
    }
    
    FileOffset Offs/*J*/= new FileOffset();
    if ((!afterToken && !canInsert(new SourceLocation(loc), Offs))
       || (afterToken && !canInsertAfterToken(new SourceLocation(loc), Offs, loc))) {
      IsCommitable = false;
      return false;
    }
    
    addInsert(new SourceLocation(loc), new FileOffset(Offs), new StringRef(text), beforePreviousInsertions);
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::insertAfterToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/Commit.h", line = 69,
   FQN="clang::edit::Commit::insertAfterToken", NM="_ZN5clang4edit6Commit16insertAfterTokenENS_14SourceLocationEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit6Commit16insertAfterTokenENS_14SourceLocationEN4llvm9StringRefEb")
  //</editor-fold>
  public boolean insertAfterToken(SourceLocation loc, StringRef text) {
    return insertAfterToken(loc, text, 
                  false);
  }
  public boolean insertAfterToken(SourceLocation loc, StringRef text, 
                  boolean beforePreviousInsertions/*= false*/) {
    return insert(new SourceLocation(loc), new StringRef(text), /*afterToken=*/ true, beforePreviousInsertions);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::insertBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/Commit.h", line = 73,
   FQN="clang::edit::Commit::insertBefore", NM="_ZN5clang4edit6Commit12insertBeforeENS_14SourceLocationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit6Commit12insertBeforeENS_14SourceLocationEN4llvm9StringRefE")
  //</editor-fold>
  public boolean insertBefore(SourceLocation loc, StringRef text) {
    return insert(new SourceLocation(loc), new StringRef(text), /*afterToken=*/ false, 
        /*beforePreviousInsertions=*/ true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::insertFromRange">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp", line = 59,
   FQN="clang::edit::Commit::insertFromRange", NM="_ZN5clang4edit6Commit15insertFromRangeENS_14SourceLocationENS_15CharSourceRangeEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit6Commit15insertFromRangeENS_14SourceLocationENS_15CharSourceRangeEbb")
  //</editor-fold>
  public boolean insertFromRange(SourceLocation loc, 
                 CharSourceRange range) {
    return insertFromRange(loc, 
                 range, 
                 false, false);
  }
  public boolean insertFromRange(SourceLocation loc, 
                 CharSourceRange range, 
                 boolean afterToken/*= false*/) {
    return insertFromRange(loc, 
                 range, 
                 afterToken, false);
  }
  public boolean insertFromRange(SourceLocation loc, 
                 CharSourceRange range, 
                 boolean afterToken/*= false*/, boolean beforePreviousInsertions/*= false*/) {
    FileOffset RangeOffs/*J*/= new FileOffset();
    /*uint*/uint$ref RangeLen = create_uint$ref();
    if (!canRemoveRange(new CharSourceRange(range), RangeOffs, RangeLen)) {
      IsCommitable = false;
      return false;
    }
    
    FileOffset Offs/*J*/= new FileOffset();
    if ((!afterToken && !canInsert(new SourceLocation(loc), Offs))
       || (afterToken && !canInsertAfterToken(new SourceLocation(loc), Offs, loc))) {
      IsCommitable = false;
      return false;
    }
    if ((PPRec != null)
       && PPRec.areInDifferentConditionalDirectiveRegion(new SourceLocation(loc), range.getBegin())) {
      IsCommitable = false;
      return false;
    }
    
    addInsertFromRange(new SourceLocation(loc), new FileOffset(Offs), new FileOffset(RangeOffs), RangeLen.$deref(), beforePreviousInsertions);
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::insertWrap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp", line = 98,
   FQN="clang::edit::Commit::insertWrap", NM="_ZN5clang4edit6Commit10insertWrapEN4llvm9StringRefENS_15CharSourceRangeES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit6Commit10insertWrapEN4llvm9StringRefENS_15CharSourceRangeES3_")
  //</editor-fold>
  public boolean insertWrap(StringRef before, CharSourceRange range, 
            StringRef after) {
    boolean commitableBefore = insert(range.getBegin(), new StringRef(before), /*afterToken=*/ false, 
        /*beforePreviousInsertions=*/ true);
    boolean commitableAfter;
    if (range.isTokenRange()) {
      commitableAfter = insertAfterToken(range.getEnd(), new StringRef(after));
    } else {
      commitableAfter = insert(range.getEnd(), new StringRef(after));
    }
    
    return commitableBefore && commitableAfter;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::remove">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp", line = 86,
   FQN="clang::edit::Commit::remove", NM="_ZN5clang4edit6Commit6removeENS_15CharSourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit6Commit6removeENS_15CharSourceRangeE")
  //</editor-fold>
  public boolean remove(CharSourceRange range) {
    FileOffset Offs/*J*/= new FileOffset();
    /*uint*/uint$ref Len = create_uint$ref();
    if (!canRemoveRange(new CharSourceRange(range), Offs, Len)) {
      IsCommitable = false;
      return false;
    }
    
    addRemove(range.getBegin(), new FileOffset(Offs), Len.$deref());
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::replace">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp", line = 111,
   FQN="clang::edit::Commit::replace", NM="_ZN5clang4edit6Commit7replaceENS_15CharSourceRangeEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit6Commit7replaceENS_15CharSourceRangeEN4llvm9StringRefE")
  //</editor-fold>
  public boolean replace(CharSourceRange range, StringRef text) {
    if (text.empty()) {
      return remove(new CharSourceRange(range));
    }
    
    FileOffset Offs/*J*/= new FileOffset();
    /*uint*/uint$ref Len = create_uint$ref();
    if (!canInsert(range.getBegin(), Offs) || !canRemoveRange(new CharSourceRange(range), Offs, Len)) {
      IsCommitable = false;
      return false;
    }
    
    addRemove(range.getBegin(), new FileOffset(Offs), Len.$deref());
    addInsert(range.getBegin(), new FileOffset(Offs), new StringRef(text), false);
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::replaceWithInner">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp", line = 127,
   FQN="clang::edit::Commit::replaceWithInner", NM="_ZN5clang4edit6Commit16replaceWithInnerENS_15CharSourceRangeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit6Commit16replaceWithInnerENS_15CharSourceRangeES2_")
  //</editor-fold>
  public boolean replaceWithInner(CharSourceRange range, 
                  CharSourceRange replacementRange) {
    FileOffset OuterBegin/*J*/= new FileOffset();
    /*uint*/uint$ref OuterLen = create_uint$ref();
    if (!canRemoveRange(new CharSourceRange(range), OuterBegin, OuterLen)) {
      IsCommitable = false;
      return false;
    }
    
    FileOffset InnerBegin/*J*/= new FileOffset();
    /*uint*/uint$ref InnerLen = create_uint$ref();
    if (!canRemoveRange(new CharSourceRange(replacementRange), InnerBegin, InnerLen)) {
      IsCommitable = false;
      return false;
    }
    
    FileOffset OuterEnd = OuterBegin.getWithOffset(OuterLen.$deref());
    FileOffset InnerEnd = InnerBegin.getWithOffset(InnerLen.$deref());
    if (OuterBegin.getFID().$noteq(InnerBegin.getFID())
       || $less_FileOffset(/*NO_COPY*/InnerBegin, /*NO_COPY*/OuterBegin)
       || $greater_FileOffset(/*NO_COPY*/InnerBegin, /*NO_COPY*/OuterEnd)
       || $greater_FileOffset(/*NO_COPY*/InnerEnd, /*NO_COPY*/OuterEnd)) {
      IsCommitable = false;
      return false;
    }
    
    addRemove(range.getBegin(), 
        new FileOffset(OuterBegin), InnerBegin.getOffset() - OuterBegin.getOffset());
    addRemove(replacementRange.getEnd(), 
        new FileOffset(InnerEnd), OuterEnd.getOffset() - InnerEnd.getOffset());
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::replaceText">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp", line = 160,
   FQN="clang::edit::Commit::replaceText", NM="_ZN5clang4edit6Commit11replaceTextENS_14SourceLocationEN4llvm9StringRefES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit6Commit11replaceTextENS_14SourceLocationEN4llvm9StringRefES4_")
  //</editor-fold>
  public boolean replaceText(SourceLocation loc, StringRef text, 
             StringRef replacementText) {
    if (text.empty() || replacementText.empty()) {
      return true;
    }
    
    FileOffset Offs/*J*/= new FileOffset();
    /*uint*/uint$ref Len = create_uint$ref();
    if (!canReplaceText(new SourceLocation(loc), new StringRef(replacementText), Offs, Len)) {
      IsCommitable = false;
      return false;
    }
    
    addRemove(new SourceLocation(loc), new FileOffset(Offs), Len.$deref());
    addInsert(new SourceLocation(loc), new FileOffset(Offs), new StringRef(text), false);
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::insertFromRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/Commit.h", line = 89,
   FQN="clang::edit::Commit::insertFromRange", NM="_ZN5clang4edit6Commit15insertFromRangeENS_14SourceLocationENS_11SourceRangeEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit6Commit15insertFromRangeENS_14SourceLocationENS_11SourceRangeEbb")
  //</editor-fold>
  public boolean insertFromRange(SourceLocation loc, SourceRange TokenRange) {
    return insertFromRange(loc, TokenRange, 
                 false, 
                 false);
  }
  public boolean insertFromRange(SourceLocation loc, SourceRange TokenRange, 
                 boolean afterToken/*= false*/) {
    return insertFromRange(loc, TokenRange, 
                 afterToken, 
                 false);
  }
  public boolean insertFromRange(SourceLocation loc, SourceRange TokenRange, 
                 boolean afterToken/*= false*/, 
                 boolean beforePreviousInsertions/*= false*/) {
    return insertFromRange(new SourceLocation(loc), CharSourceRange.getTokenRange(/*NO_COPY*/TokenRange), 
        afterToken, beforePreviousInsertions);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::insertWrap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/Commit.h", line = 95,
   FQN="clang::edit::Commit::insertWrap", NM="_ZN5clang4edit6Commit10insertWrapEN4llvm9StringRefENS_11SourceRangeES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit6Commit10insertWrapEN4llvm9StringRefENS_11SourceRangeES3_")
  //</editor-fold>
  public boolean insertWrap(StringRef before, SourceRange TokenRange, StringRef after) {
    return insertWrap(new StringRef(before), CharSourceRange.getTokenRange(/*NO_COPY*/TokenRange), new StringRef(after));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::remove">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/Commit.h", line = 98,
   FQN="clang::edit::Commit::remove", NM="_ZN5clang4edit6Commit6removeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit6Commit6removeENS_11SourceRangeE")
  //</editor-fold>
  public boolean remove(SourceRange TokenRange) {
    return remove(CharSourceRange.getTokenRange(/*NO_COPY*/TokenRange));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::replace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/Commit.h", line = 101,
   FQN="clang::edit::Commit::replace", NM="_ZN5clang4edit6Commit7replaceENS_11SourceRangeEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit6Commit7replaceENS_11SourceRangeEN4llvm9StringRefE")
  //</editor-fold>
  public boolean replace(SourceRange TokenRange, StringRef text) {
    return replace(CharSourceRange.getTokenRange(/*NO_COPY*/TokenRange), new StringRef(text));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::replaceWithInner">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/Commit.h", line = 104,
   FQN="clang::edit::Commit::replaceWithInner", NM="_ZN5clang4edit6Commit16replaceWithInnerENS_11SourceRangeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit6Commit16replaceWithInnerENS_11SourceRangeES2_")
  //</editor-fold>
  public boolean replaceWithInner(SourceRange TokenRange, SourceRange TokenInnerRange) {
    return replaceWithInner(CharSourceRange.getTokenRange(/*NO_COPY*/TokenRange), 
        CharSourceRange.getTokenRange(/*NO_COPY*/TokenInnerRange));
  }

  
  /*typedef SmallVectorImpl<Edit>::const_iterator edit_iterator*/
//  public final class edit_iterator extends type$ptr<Edit>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::edit_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/Commit.h", line = 110,
   FQN="clang::edit::Commit::edit_begin", NM="_ZNK5clang4edit6Commit10edit_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZNK5clang4edit6Commit10edit_beginEv")
  //</editor-fold>
  public type$ptr<Edit> edit_begin() /*const*/ {
    return CachedEdits.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::edit_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/Commit.h", line = 111,
   FQN="clang::edit::Commit::edit_end", NM="_ZNK5clang4edit6Commit8edit_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZNK5clang4edit6Commit8edit_endEv")
  //</editor-fold>
  public type$ptr<Edit> edit_end() /*const*/ {
    return CachedEdits.end$Const();
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::addInsert">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp", line = 177,
   FQN="clang::edit::Commit::addInsert", NM="_ZN5clang4edit6Commit9addInsertENS_14SourceLocationENS0_10FileOffsetEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit6Commit9addInsertENS_14SourceLocationENS0_10FileOffsetEN4llvm9StringRefEb")
  //</editor-fold>
  private void addInsert(SourceLocation OrigLoc, FileOffset Offs, StringRef text, 
           boolean beforePreviousInsertions) {
    if (text.empty()) {
      return;
    }
    
    Edit data/*J*/= new Edit();
    data.Kind = EditKind.Act_Insert;
    data.OrigLoc.$assign(OrigLoc);
    data.Offset.$assign(Offs);
    data.Text.$assignMove(text.copy(StrAlloc));
    data.BeforePrev = beforePreviousInsertions;
    CachedEdits.push_back(data);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::addInsertFromRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp", line = 191,
   FQN="clang::edit::Commit::addInsertFromRange", NM="_ZN5clang4edit6Commit18addInsertFromRangeENS_14SourceLocationENS0_10FileOffsetES3_jb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit6Commit18addInsertFromRangeENS_14SourceLocationENS0_10FileOffsetES3_jb")
  //</editor-fold>
  private void addInsertFromRange(SourceLocation OrigLoc, FileOffset Offs, 
                    FileOffset RangeOffs, /*uint*/int RangeLen, 
                    boolean beforePreviousInsertions) {
    if (RangeLen == 0) {
      return;
    }
    
    Edit data/*J*/= new Edit();
    data.Kind = EditKind.Act_InsertFromRange;
    data.OrigLoc.$assign(OrigLoc);
    data.Offset.$assign(Offs);
    data.InsertFromRangeOffs.$assign(RangeOffs);
    data.Length = RangeLen;
    data.BeforePrev = beforePreviousInsertions;
    CachedEdits.push_back(data);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::addRemove">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp", line = 207,
   FQN="clang::edit::Commit::addRemove", NM="_ZN5clang4edit6Commit9addRemoveENS_14SourceLocationENS0_10FileOffsetEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit6Commit9addRemoveENS_14SourceLocationENS0_10FileOffsetEj")
  //</editor-fold>
  private void addRemove(SourceLocation OrigLoc, 
           FileOffset Offs, /*uint*/int Len) {
    if (Len == 0) {
      return;
    }
    
    Edit data/*J*/= new Edit();
    data.Kind = EditKind.Act_Remove;
    data.OrigLoc.$assign(OrigLoc);
    data.Offset.$assign(Offs);
    data.Length = Len;
    CachedEdits.push_back(data);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::canInsert">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp", line = 220,
   FQN="clang::edit::Commit::canInsert", NM="_ZN5clang4edit6Commit9canInsertENS_14SourceLocationERNS0_10FileOffsetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit6Commit9canInsertENS_14SourceLocationERNS0_10FileOffsetE")
  //</editor-fold>
  private boolean canInsert(SourceLocation loc, FileOffset /*&*/ offs) {
    if (loc.isInvalid()) {
      return false;
    }
    if (loc.isMacroID()) {
      isAtStartOfMacroExpansion(new SourceLocation(loc), /*AddrOf*/loc);
    }
    
    /*const*/ SourceManager /*&*/ SM = SourceMgr;
    while (SM.isMacroArgExpansion(/*NO_COPY*/loc)) {
      loc.$assignMove(SM.getImmediateSpellingLoc(/*NO_COPY*/loc));
    }
    if (loc.isMacroID()) {
      if (!isAtStartOfMacroExpansion(new SourceLocation(loc), /*AddrOf*/loc)) {
        return false;
      }
    }
    if (SM.isInSystemHeader(/*NO_COPY*/loc)) {
      return false;
    }
    
    std.pairTypeUInt<FileID> locInfo = SM.getDecomposedLoc(/*NO_COPY*/loc);
    if (locInfo.first.isInvalid()) {
      return false;
    }
    offs.$assignMove(new FileOffset(new FileID(locInfo.first), locInfo.second));
    return canInsertInOffset(new SourceLocation(loc), new FileOffset(offs));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::canInsertAfterToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp", line = 245,
   FQN="clang::edit::Commit::canInsertAfterToken", NM="_ZN5clang4edit6Commit19canInsertAfterTokenENS_14SourceLocationERNS0_10FileOffsetERS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit6Commit19canInsertAfterTokenENS_14SourceLocationERNS0_10FileOffsetERS2_")
  //</editor-fold>
  private boolean canInsertAfterToken(SourceLocation loc, FileOffset /*&*/ offs, 
                     SourceLocation /*&*/ AfterLoc) {
    if (loc.isInvalid()) {
      
      return false;
    }
    
    SourceLocation spellLoc = SourceMgr.getSpellingLoc(/*NO_COPY*/loc);
    /*uint*/int tokLen = Lexer.MeasureTokenLength(/*NO_COPY*/spellLoc, SourceMgr, LangOpts);
    AfterLoc.$assignMove(loc.getLocWithOffset(tokLen));
    if (loc.isMacroID()) {
      isAtEndOfMacroExpansion(new SourceLocation(loc), /*AddrOf*/loc);
    }
    
    /*const*/ SourceManager /*&*/ SM = SourceMgr;
    while (SM.isMacroArgExpansion(/*NO_COPY*/loc)) {
      loc.$assignMove(SM.getImmediateSpellingLoc(/*NO_COPY*/loc));
    }
    if (loc.isMacroID()) {
      if (!isAtEndOfMacroExpansion(new SourceLocation(loc), /*AddrOf*/loc)) {
        return false;
      }
    }
    if (SM.isInSystemHeader(/*NO_COPY*/loc)) {
      return false;
    }
    
    loc.$assignMove(Lexer.getLocForEndOfToken(/*NO_COPY*/loc, 0, SourceMgr, LangOpts));
    if (loc.isInvalid()) {
      return false;
    }
    
    std.pairTypeUInt<FileID> locInfo = SM.getDecomposedLoc(/*NO_COPY*/loc);
    if (locInfo.first.isInvalid()) {
      return false;
    }
    offs.$assignMove(new FileOffset(new FileID(locInfo.first), locInfo.second));
    return canInsertInOffset(new SourceLocation(loc), new FileOffset(offs));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::canInsertInOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp", line = 280,
   FQN="clang::edit::Commit::canInsertInOffset", NM="_ZN5clang4edit6Commit17canInsertInOffsetENS_14SourceLocationENS0_10FileOffsetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit6Commit17canInsertInOffsetENS_14SourceLocationENS0_10FileOffsetE")
  //</editor-fold>
  private boolean canInsertInOffset(SourceLocation OrigLoc, FileOffset Offs) {
    for (/*uint*/int i = 0, e = CachedEdits.size(); i != e; ++i) {
      Edit /*&*/ act = CachedEdits.$at(i);
      if (act.Kind == EditKind.Act_Remove) {
        if (act.Offset.getFID().$eq(Offs.getFID())
           && $greater_FileOffset(/*NO_COPY*/Offs, /*NO_COPY*/act.Offset) && $less_FileOffset(/*NO_COPY*/Offs, act.Offset.getWithOffset(act.Length))) {
          return false; // position has been removed.
        }
      }
    }
    if (!(Editor != null)) {
      return true;
    }
    return Editor.canInsertInOffset(new SourceLocation(OrigLoc), new FileOffset(Offs));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::canRemoveRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp", line = 295,
   FQN="clang::edit::Commit::canRemoveRange", NM="_ZN5clang4edit6Commit14canRemoveRangeENS_15CharSourceRangeERNS0_10FileOffsetERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit6Commit14canRemoveRangeENS_15CharSourceRangeERNS0_10FileOffsetERj")
  //</editor-fold>
  private boolean canRemoveRange(CharSourceRange range, 
                FileOffset /*&*/ Offs, uint$ref/*uint &*/ Len) {
    /*const*/ SourceManager /*&*/ SM = SourceMgr;
    range.$assignMove(Lexer.makeFileCharRange(new CharSourceRange(range), SM, LangOpts));
    if (range.isInvalid()) {
      return false;
    }
    if (range.getBegin().isMacroID() || range.getEnd().isMacroID()) {
      return false;
    }
    if (SM.isInSystemHeader(range.getBegin())
       || SM.isInSystemHeader(range.getEnd())) {
      return false;
    }
    if ((PPRec != null) && PPRec.rangeIntersectsConditionalDirective(range.getAsRange())) {
      return false;
    }
    
    std.pairTypeUInt<FileID> beginInfo = SM.getDecomposedLoc(range.getBegin());
    std.pairTypeUInt<FileID> endInfo = SM.getDecomposedLoc(range.getEnd());
    if (beginInfo.first.$noteq(endInfo.first)
       || $greater_uint(beginInfo.second, endInfo.second)) {
      return false;
    }
    
    Offs.$assignMove(new FileOffset(new FileID(beginInfo.first), beginInfo.second));
    Len.$set(endInfo.second - beginInfo.second);
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::canReplaceText">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp", line = 322,
   FQN="clang::edit::Commit::canReplaceText", NM="_ZN5clang4edit6Commit14canReplaceTextENS_14SourceLocationEN4llvm9StringRefERNS0_10FileOffsetERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit6Commit14canReplaceTextENS_14SourceLocationEN4llvm9StringRefERNS0_10FileOffsetERj")
  //</editor-fold>
  private boolean canReplaceText(SourceLocation loc, StringRef text, 
                FileOffset /*&*/ Offs, uint$ref/*uint &*/ Len) {
    assert (!text.empty());
    if (!canInsert(new SourceLocation(loc), Offs)) {
      return false;
    }
    
    // Try to load the file buffer.
    bool$ptr invalidTemp = create_bool$ptr(false);
    StringRef file = SourceMgr.getBufferData(Offs.getFID(), /*AddrOf*/invalidTemp);
    if (invalidTemp.$star()) {
      return false;
    }
    
    Len.$set(text.size());
    return file.substr(Offs.getOffset()).startswith(/*NO_COPY*/text);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::commitInsert">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/Commit.h", line = 129,
   FQN="clang::edit::Commit::commitInsert", NM="_ZN5clang4edit6Commit12commitInsertENS0_10FileOffsetEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit6Commit12commitInsertENS0_10FileOffsetEN4llvm9StringRefEb")
  //</editor-fold>
  private void commitInsert(FileOffset offset, StringRef text, 
              boolean beforePreviousInsertions) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::commitRemove">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/Commit.h", line = 131,
   FQN="clang::edit::Commit::commitRemove", NM="_ZN5clang4edit6Commit12commitRemoveENS0_10FileOffsetEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit6Commit12commitRemoveENS0_10FileOffsetEj")
  //</editor-fold>
  private void commitRemove(FileOffset offset, /*uint*/int length) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::isAtStartOfMacroExpansion">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp", line = 339,
   FQN="clang::edit::Commit::isAtStartOfMacroExpansion", NM="_ZNK5clang4edit6Commit25isAtStartOfMacroExpansionENS_14SourceLocationEPS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZNK5clang4edit6Commit25isAtStartOfMacroExpansionENS_14SourceLocationEPS2_")
  //</editor-fold>
  private boolean isAtStartOfMacroExpansion(SourceLocation loc) /*const*/ {
    return isAtStartOfMacroExpansion(loc, 
                           (SourceLocation /*P*/ )null);
  }
  private boolean isAtStartOfMacroExpansion(SourceLocation loc, 
                           SourceLocation /*P*/ MacroBegin/*= null*/) /*const*/ {
    return Lexer.isAtStartOfMacroExpansion(/*NO_COPY*/loc, SourceMgr, LangOpts, MacroBegin);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::isAtEndOfMacroExpansion">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp", line = 343,
   FQN="clang::edit::Commit::isAtEndOfMacroExpansion", NM="_ZNK5clang4edit6Commit23isAtEndOfMacroExpansionENS_14SourceLocationEPS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZNK5clang4edit6Commit23isAtEndOfMacroExpansionENS_14SourceLocationEPS2_")
  //</editor-fold>
  private boolean isAtEndOfMacroExpansion(SourceLocation loc) /*const*/ {
    return isAtEndOfMacroExpansion(loc, 
                         (SourceLocation /*P*/ )null);
  }
  private boolean isAtEndOfMacroExpansion(SourceLocation loc, 
                         SourceLocation /*P*/ MacroEnd/*= null*/) /*const*/ {
    return Lexer.isAtEndOfMacroExpansion(new SourceLocation(loc), SourceMgr, LangOpts, MacroEnd);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::Commit::~Commit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/Commit.h", line = 25,
   FQN="clang::edit::Commit::~Commit", NM="_ZN5clang4edit6CommitD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang4edit6CommitD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    StrAlloc.$destroy();
    CachedEdits.$destroy();
    //END JDestroy
  }


  
  @Override public String toString() {
    return "" + "SourceMgr=" + SourceMgr // NOI18N
              + ", LangOpts=" + LangOpts // NOI18N
              + ", PPRec=" + PPRec // NOI18N
              + ", Editor=" + Editor // NOI18N
              + ", IsCommitable=" + IsCommitable // NOI18N
              + ", CachedEdits=" + CachedEdits // NOI18N
              + ", StrAlloc=" + StrAlloc; // NOI18N
  }
}
