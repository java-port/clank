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

package org.clang.staticanalyzer.checkers.impl;

import java.util.Comparator;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.checkers.ento.impl.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import org.clang.staticanalyzer.java.*;
import org.clang.basic.llvm.DenseMapInfoSelector;
import org.llvm.support.sys.unicode;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NonLocalizedStringChecker">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 60,
 FQN="(anonymous namespace)::NonLocalizedStringChecker", NM="_ZN12_GLOBAL__N_125NonLocalizedStringCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN12_GLOBAL__N_125NonLocalizedStringCheckerE")
//</editor-fold>
public class NonLocalizedStringChecker extends /*public*/ Checker/*<PostCall, PreObjCMessage, PostObjCMessage, PostStmt<ObjCStringLiteral> >*/ 
        implements org.clang.staticanalyzer.java.PreObjCMessageChecker, org.clang.staticanalyzer.java.PostStmtChecker, org.clang.staticanalyzer.java.PostObjCMessageChecker, org.clang.staticanalyzer.java.PostCallChecker, Destructors.ClassWithDestructor {

  private /*mutable */std.unique_ptr<BugType> BT;
  
  // Methods that require a localized string
  private /*mutable */DenseMap</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>> UIMethods;
  // Methods that return a localized string
  private /*mutable */SmallSet<std.pairPtrType</*const*/ IdentifierInfo /*P*/ , Selector>> LSM;
  // C Functions that return a localized string
  private /*mutable */SmallSetT$PLess$T$P</*const*/ IdentifierInfo /*P*/ > LSF;
  
  
  /// Initializes a list of methods that require a localized string
  /// Format: {"ClassName", {{"selectorName:", LocStringArg#}, ...}, ...}
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NonLocalizedStringChecker::initUIMethods">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 154,
   FQN="(anonymous namespace)::NonLocalizedStringChecker::initUIMethods", NM="_ZNK12_GLOBAL__N_125NonLocalizedStringChecker13initUIMethodsERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZNK12_GLOBAL__N_125NonLocalizedStringChecker13initUIMethodsERN5clang10ASTContextE")
  //</editor-fold>
  private void initUIMethods(final ASTContext /*&*/ Ctx) /*const*/ {
    if (!UIMethods.empty()) {
      return;
    }
    
    // UI Methods
    final DenseMapTypeUChar<Selector> /*&*/ UISearchDisplayControllerM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"UISearchDisplayController"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    UISearchDisplayControllerM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setSearchResultsTitle")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ UITabBarItemM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"UITabBarItem"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    IdentifierInfo /*P*/ initWithTitleUITabBarItemTag[/*3*/] = new IdentifierInfo /*P*/  [/*3*/] {
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"initWithTitle"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"image"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"tag")))};
    UITabBarItemM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(3, create_type$ptr(initWithTitleUITabBarItemTag)), (byte)0)/* }*/);
    IdentifierInfo /*P*/ initWithTitleUITabBarItemImage[/*3*/] = new IdentifierInfo /*P*/  [/*3*/] {
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"initWithTitle"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"image"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"selectedImage")))};
    UITabBarItemM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(3, create_type$ptr(initWithTitleUITabBarItemImage)), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSDockTileM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSDockTile"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSDockTileM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setBadgeLabel")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSStatusItemM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSStatusItem"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSStatusItemM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle")))), (byte)0)/* }*/);
    NSStatusItemM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setToolTip")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ UITableViewRowActionM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"UITableViewRowAction"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    IdentifierInfo /*P*/ rowActionWithStyleUITableViewRowAction[/*3*/] = new IdentifierInfo /*P*/  [/*3*/] {
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"rowActionWithStyle"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"title"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"handler")))};
    UITableViewRowActionM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(3, create_type$ptr(rowActionWithStyleUITableViewRowAction)), (byte)1)/* }*/);
    UITableViewRowActionM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSBoxM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSBox"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSBoxM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSButtonM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSButton"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSButtonM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle")))), (byte)0)/* }*/);
    NSButtonM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setAlternateTitle")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSSavePanelM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSSavePanel"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSSavePanelM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setPrompt")))), (byte)0)/* }*/);
    NSSavePanelM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle")))), (byte)0)/* }*/);
    NSSavePanelM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setNameFieldLabel")))), (byte)0)/* }*/);
    NSSavePanelM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setNameFieldStringValue")))), (byte)0)/* }*/);
    NSSavePanelM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setMessage")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ UIPrintInfoM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"UIPrintInfo"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    UIPrintInfoM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setJobName")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSTabViewItemM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSTabViewItem"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSTabViewItemM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setLabel")))), (byte)0)/* }*/);
    NSTabViewItemM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setToolTip")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSBrowserM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSBrowser"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    IdentifierInfo /*P*/ setTitleNSBrowser[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"ofColumn")))};
    NSBrowserM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(2, create_type$ptr(setTitleNSBrowser)), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ UIAccessibilityElementM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"UIAccessibilityElement"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    UIAccessibilityElementM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setAccessibilityLabel")))), (byte)0)/* }*/);
    UIAccessibilityElementM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setAccessibilityHint")))), (byte)0)/* }*/);
    UIAccessibilityElementM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setAccessibilityValue")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ UIAlertActionM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"UIAlertAction"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    IdentifierInfo /*P*/ actionWithTitleUIAlertAction[/*3*/] = new IdentifierInfo /*P*/  [/*3*/] {
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"actionWithTitle"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"style"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"handler")))};
    UIAlertActionM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(3, create_type$ptr(actionWithTitleUIAlertAction)), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSPopUpButtonM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSPopUpButton"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSPopUpButtonM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"addItemWithTitle")))), (byte)0)/* }*/);
    IdentifierInfo /*P*/ insertItemWithTitleNSPopUpButton[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {$AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"insertItemWithTitle"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"atIndex")))};
    NSPopUpButtonM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(2, create_type$ptr(insertItemWithTitleNSPopUpButton)), (byte)0)/* }*/);
    NSPopUpButtonM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"removeItemWithTitle")))), (byte)0)/* }*/);
    NSPopUpButtonM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"selectItemWithTitle")))), (byte)0)/* }*/);
    NSPopUpButtonM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSTableViewRowActionM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSTableViewRowAction"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    IdentifierInfo /*P*/ rowActionWithStyleNSTableViewRowAction[/*3*/] = new IdentifierInfo /*P*/  [/*3*/] {
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"rowActionWithStyle"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"title"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"handler")))};
    NSTableViewRowActionM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(3, create_type$ptr(rowActionWithStyleNSTableViewRowAction)), (byte)1)/* }*/);
    NSTableViewRowActionM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSImageM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSImage"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSImageM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setAccessibilityDescription")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSUserActivityM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSUserActivity"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSUserActivityM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSPathControlItemM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSPathControlItem"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSPathControlItemM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSCellM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSCell"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSCellM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"initTextCell")))), (byte)0)/* }*/);
    NSCellM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle")))), (byte)0)/* }*/);
    NSCellM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setStringValue")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSPathControlM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSPathControl"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSPathControlM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setPlaceholderString")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ UIAccessibilityM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"UIAccessibility"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    UIAccessibilityM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setAccessibilityLabel")))), (byte)0)/* }*/);
    UIAccessibilityM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setAccessibilityHint")))), (byte)0)/* }*/);
    UIAccessibilityM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setAccessibilityValue")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSTableColumnM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSTableColumn"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSTableColumnM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle")))), (byte)0)/* }*/);
    NSTableColumnM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setHeaderToolTip")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSSegmentedControlM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSSegmentedControl"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    IdentifierInfo /*P*/ setLabelNSSegmentedControl[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {$AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setLabel"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"forSegment")))};
    NSSegmentedControlM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(2, create_type$ptr(setLabelNSSegmentedControl)), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSButtonCellM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSButtonCell"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSButtonCellM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle")))), (byte)0)/* }*/);
    NSButtonCellM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setAlternateTitle")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSSliderCellM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSSliderCell"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSSliderCellM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSControlM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSControl"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSControlM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setStringValue")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSAccessibilityM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSAccessibility"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSAccessibilityM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setAccessibilityValueDescription")))), (byte)0)/* }*/);
    NSAccessibilityM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setAccessibilityLabel")))), (byte)0)/* }*/);
    NSAccessibilityM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setAccessibilityTitle")))), (byte)0)/* }*/);
    NSAccessibilityM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setAccessibilityPlaceholderValue")))), (byte)0)/* }*/);
    NSAccessibilityM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setAccessibilityHelp")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSMatrixM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSMatrix"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    IdentifierInfo /*P*/ setToolTipNSMatrix[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setToolTip"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"forCell")))};
    NSMatrixM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(2, create_type$ptr(setToolTipNSMatrix)), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSPrintPanelM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSPrintPanel"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSPrintPanelM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setDefaultButtonTitle")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ UILocalNotificationM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"UILocalNotification"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    UILocalNotificationM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setAlertBody")))), (byte)0)/* }*/);
    UILocalNotificationM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setAlertAction")))), (byte)0)/* }*/);
    UILocalNotificationM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setAlertTitle")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSSliderM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSSlider"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSSliderM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ UIMenuItemM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"UIMenuItem"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    IdentifierInfo /*P*/ initWithTitleUIMenuItem[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"initWithTitle"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"action")))};
    UIMenuItemM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(2, create_type$ptr(initWithTitleUIMenuItem)), (byte)0)/* }*/);
    UIMenuItemM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ UIAlertControllerM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"UIAlertController"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    IdentifierInfo /*P*/ alertControllerWithTitleUIAlertController[/*3*/] = new IdentifierInfo /*P*/  [/*3*/] {
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"alertControllerWithTitle"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"message"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"preferredStyle")))};
    UIAlertControllerM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(3, create_type$ptr(alertControllerWithTitleUIAlertController)), (byte)1)/* }*/);
    UIAlertControllerM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle")))), (byte)0)/* }*/);
    UIAlertControllerM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setMessage")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ UIApplicationShortcutItemM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"UIApplicationShortcutItem"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    IdentifierInfo /*P*/ initWithTypeUIApplicationShortcutItemIcon[/*5*/] = new IdentifierInfo /*P*/  [/*5*/] {
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"initWithType"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"localizedTitle"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"localizedSubtitle"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"icon"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"userInfo")))};
    UIApplicationShortcutItemM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(5, create_type$ptr(initWithTypeUIApplicationShortcutItemIcon)), (byte)1)/* }*/);
    IdentifierInfo /*P*/ initWithTypeUIApplicationShortcutItem[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {$AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"initWithType"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"localizedTitle")))};
    UIApplicationShortcutItemM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(2, create_type$ptr(initWithTypeUIApplicationShortcutItem)), (byte)1)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ UIActionSheetM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"UIActionSheet"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    IdentifierInfo /*P*/ initWithTitleUIActionSheet[/*5*/] = new IdentifierInfo /*P*/  [/*5*/] {
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"initWithTitle"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"delegate"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"cancelButtonTitle"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"destructiveButtonTitle"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"otherButtonTitles")))};
    UIActionSheetM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(5, create_type$ptr(initWithTitleUIActionSheet)), (byte)0)/* }*/);
    UIActionSheetM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"addButtonWithTitle")))), (byte)0)/* }*/);
    UIActionSheetM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSURLSessionTaskM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSURLSessionTask"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSURLSessionTaskM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTaskDescription")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ UIAccessibilityCustomActionM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"UIAccessibilityCustomAction"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    IdentifierInfo /*P*/ initWithNameUIAccessibilityCustomAction[/*3*/] = new IdentifierInfo /*P*/  [/*3*/] {
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"initWithName"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"target"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"selector")))};
    UIAccessibilityCustomActionM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(3, create_type$ptr(initWithNameUIAccessibilityCustomAction)), (byte)0)/* }*/);
    UIAccessibilityCustomActionM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setName")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ UISearchBarM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"UISearchBar"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    UISearchBarM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setText")))), (byte)0)/* }*/);
    UISearchBarM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setPrompt")))), (byte)0)/* }*/);
    UISearchBarM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setPlaceholder")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ UIBarItemM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"UIBarItem"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    UIBarItemM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ UITextViewM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"UITextView"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    UITextViewM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setText")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSViewM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSView"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSViewM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setToolTip")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSTextFieldM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSTextField"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSTextFieldM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setPlaceholderString")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSAttributedStringM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSAttributedString"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSAttributedStringM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"initWithString")))), (byte)0)/* }*/);
    IdentifierInfo /*P*/ initWithStringNSAttributedString[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {$AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"initWithString"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"attributes")))};
    NSAttributedStringM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(2, create_type$ptr(initWithStringNSAttributedString)), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSTextM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSText"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSTextM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setString")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ UIKeyCommandM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"UIKeyCommand"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    IdentifierInfo /*P*/ keyCommandWithInputUIKeyCommand[/*4*/] = new IdentifierInfo /*P*/  [/*4*/] {
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"keyCommandWithInput"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"modifierFlags"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"action"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"discoverabilityTitle")))};
    UIKeyCommandM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(4, create_type$ptr(keyCommandWithInputUIKeyCommand)), (byte)3)/* }*/);
    UIKeyCommandM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setDiscoverabilityTitle")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ UILabelM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"UILabel"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    UILabelM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setText")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSAlertM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSAlert"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    IdentifierInfo /*P*/ alertWithMessageTextNSAlert[/*5*/] = new IdentifierInfo /*P*/  [/*5*/] {
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"alertWithMessageText"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"defaultButton"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"alternateButton"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"otherButton"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"informativeTextWithFormat")))};
    NSAlertM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(5, create_type$ptr(alertWithMessageTextNSAlert)), (byte)0)/* }*/);
    NSAlertM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"addButtonWithTitle")))), (byte)0)/* }*/);
    NSAlertM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setMessageText")))), (byte)0)/* }*/);
    NSAlertM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setInformativeText")))), (byte)0)/* }*/);
    NSAlertM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setHelpAnchor")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ UIMutableApplicationShortcutItemM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"UIMutableApplicationShortcutItem"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    UIMutableApplicationShortcutItemM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setLocalizedTitle")))), (byte)0)/* }*/);
    UIMutableApplicationShortcutItemM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setLocalizedSubtitle")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ UIButtonM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"UIButton"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    IdentifierInfo /*P*/ setTitleUIButton[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"forState")))};
    UIButtonM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(2, create_type$ptr(setTitleUIButton)), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSWindowM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSWindow"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSWindowM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle")))), (byte)0)/* }*/);
    IdentifierInfo /*P*/ minFrameWidthWithTitleNSWindow[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {$AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"minFrameWidthWithTitle"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"styleMask")))};
    NSWindowM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(2, create_type$ptr(minFrameWidthWithTitleNSWindow)), (byte)0)/* }*/);
    NSWindowM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setMiniwindowTitle")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSPathCellM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSPathCell"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSPathCellM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setPlaceholderString")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ UIDocumentMenuViewControllerM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"UIDocumentMenuViewController"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    IdentifierInfo /*P*/ addOptionWithTitleUIDocumentMenuViewController[/*4*/] = new IdentifierInfo /*P*/  [/*4*/] {
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"addOptionWithTitle"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"image"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"order"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"handler")))};
    UIDocumentMenuViewControllerM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(4, create_type$ptr(addOptionWithTitleUIDocumentMenuViewController)), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ UINavigationItemM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"UINavigationItem"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    UINavigationItemM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"initWithTitle")))), (byte)0)/* }*/);
    UINavigationItemM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle")))), (byte)0)/* }*/);
    UINavigationItemM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setPrompt")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ UIAlertViewM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"UIAlertView"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    IdentifierInfo /*P*/ initWithTitleUIAlertView[/*5*/] = new IdentifierInfo /*P*/  [/*5*/] {
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"initWithTitle"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"message"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"delegate"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"cancelButtonTitle"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"otherButtonTitles")))};
    UIAlertViewM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(5, create_type$ptr(initWithTitleUIAlertView)), (byte)0)/* }*/);
    UIAlertViewM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"addButtonWithTitle")))), (byte)0)/* }*/);
    UIAlertViewM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle")))), (byte)0)/* }*/);
    UIAlertViewM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setMessage")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSFormCellM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSFormCell"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSFormCellM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"initTextCell")))), (byte)0)/* }*/);
    NSFormCellM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle")))), (byte)0)/* }*/);
    NSFormCellM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setPlaceholderString")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSUserNotificationM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSUserNotification"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSUserNotificationM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle")))), (byte)0)/* }*/);
    NSUserNotificationM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setSubtitle")))), (byte)0)/* }*/);
    NSUserNotificationM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setInformativeText")))), (byte)0)/* }*/);
    NSUserNotificationM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setActionButtonTitle")))), (byte)0)/* }*/);
    NSUserNotificationM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setOtherButtonTitle")))), (byte)0)/* }*/);
    NSUserNotificationM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setResponsePlaceholder")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSToolbarItemM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSToolbarItem"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSToolbarItemM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setLabel")))), (byte)0)/* }*/);
    NSToolbarItemM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setPaletteLabel")))), (byte)0)/* }*/);
    NSToolbarItemM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setToolTip")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSProgressM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSProgress"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSProgressM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setLocalizedDescription")))), (byte)0)/* }*/);
    NSProgressM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setLocalizedAdditionalDescription")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSSegmentedCellM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSSegmentedCell"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    IdentifierInfo /*P*/ setLabelNSSegmentedCell[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setLabel"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"forSegment")))};
    NSSegmentedCellM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(2, create_type$ptr(setLabelNSSegmentedCell)), (byte)0)/* }*/);
    IdentifierInfo /*P*/ setToolTipNSSegmentedCell[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setToolTip"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"forSegment")))};
    NSSegmentedCellM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(2, create_type$ptr(setToolTipNSSegmentedCell)), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSUndoManagerM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSUndoManager"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSUndoManagerM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setActionName")))), (byte)0)/* }*/);
    NSUndoManagerM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"undoMenuTitleForUndoActionName")))), (byte)0)/* }*/);
    NSUndoManagerM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"redoMenuTitleForUndoActionName")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSMenuItemM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSMenuItem"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    IdentifierInfo /*P*/ initWithTitleNSMenuItem[/*3*/] = new IdentifierInfo /*P*/  [/*3*/] {
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"initWithTitle"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"action"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"keyEquivalent")))};
    NSMenuItemM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(3, create_type$ptr(initWithTitleNSMenuItem)), (byte)0)/* }*/);
    NSMenuItemM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle")))), (byte)0)/* }*/);
    NSMenuItemM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setToolTip")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSPopUpButtonCellM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSPopUpButtonCell"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    IdentifierInfo /*P*/ initTextCellNSPopUpButtonCell[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {$AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"initTextCell"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"pullsDown")))};
    NSPopUpButtonCellM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(2, create_type$ptr(initTextCellNSPopUpButtonCell)), (byte)0)/* }*/);
    NSPopUpButtonCellM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"addItemWithTitle")))), (byte)0)/* }*/);
    IdentifierInfo /*P*/ insertItemWithTitleNSPopUpButtonCell[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {$AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"insertItemWithTitle"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"atIndex")))};
    NSPopUpButtonCellM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(2, create_type$ptr(insertItemWithTitleNSPopUpButtonCell)), (byte)0)/* }*/);
    NSPopUpButtonCellM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"removeItemWithTitle")))), (byte)0)/* }*/);
    NSPopUpButtonCellM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"selectItemWithTitle")))), (byte)0)/* }*/);
    NSPopUpButtonCellM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSViewControllerM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSViewController"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSViewControllerM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSMenuM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSMenu"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSMenuM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"initWithTitle")))), (byte)0)/* }*/);
    IdentifierInfo /*P*/ insertItemWithTitleNSMenu[/*4*/] = new IdentifierInfo /*P*/  [/*4*/] {
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"insertItemWithTitle"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"action"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"keyEquivalent"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"atIndex")))};
    NSMenuM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(4, create_type$ptr(insertItemWithTitleNSMenu)), (byte)0)/* }*/);
    IdentifierInfo /*P*/ addItemWithTitleNSMenu[/*3*/] = new IdentifierInfo /*P*/  [/*3*/] {
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"addItemWithTitle"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"action"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"keyEquivalent")))};
    NSMenuM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(3, create_type$ptr(addItemWithTitleNSMenu)), (byte)0)/* }*/);
    NSMenuM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ UIMutableUserNotificationActionM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"UIMutableUserNotificationAction"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    UIMutableUserNotificationActionM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSFormM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSForm"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSFormM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"addEntry")))), (byte)0)/* }*/);
    IdentifierInfo /*P*/ insertEntryNSForm[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"insertEntry"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"atIndex")))};
    NSFormM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(2, create_type$ptr(insertEntryNSForm)), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSTextFieldCellM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSTextFieldCell"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSTextFieldCellM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setPlaceholderString")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSUserNotificationActionM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSUserNotificationAction"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    IdentifierInfo /*P*/ actionWithIdentifierNSUserNotificationAction[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {$AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"actionWithIdentifier"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"title")))};
    NSUserNotificationActionM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(2, create_type$ptr(actionWithIdentifierNSUserNotificationAction)), (byte)1)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ NSURLSessionM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSURLSession"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    NSURLSessionM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setSessionDescription")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ UITextFieldM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"UITextField"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    UITextFieldM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setText")))), (byte)0)/* }*/);
    UITextFieldM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setPlaceholder")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ UIBarButtonItemM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"UIBarButtonItem"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    IdentifierInfo /*P*/ initWithTitleUIBarButtonItem[/*4*/] = new IdentifierInfo /*P*/  [/*4*/] {
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"initWithTitle"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"style"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"target"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"action")))};
    UIBarButtonItemM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(4, create_type$ptr(initWithTitleUIBarButtonItem)), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ UIViewControllerM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"UIViewController"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    UIViewControllerM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle")))), (byte)0)/* }*/);
    final DenseMapTypeUChar<Selector> /*&*/ UISegmentedControlM = UIMethods.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"UISegmentedControl"))), new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte)0))/* }*/).first.$arrow().second;
    IdentifierInfo /*P*/ insertSegmentWithTitleUISegmentedControl[/*3*/] = new IdentifierInfo /*P*/  [/*3*/] {
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"insertSegmentWithTitle"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"atIndex"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"animated")))};
    UISegmentedControlM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(3, create_type$ptr(insertSegmentWithTitleUISegmentedControl)), (byte)0)/* }*/);
    IdentifierInfo /*P*/ setTitleUISegmentedControl[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {$AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setTitle"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"forSegmentAtIndex")))};
    UISegmentedControlM.insert_pair$KeyT$ValueT(/*{ */new std.pairTypeUChar<Selector>(JD$T$RR_T1$RR.INSTANCE, Ctx.Selectors.getSelector(2, create_type$ptr(setTitleUISegmentedControl)), (byte)0)/* }*/);
  }

  
  /// Initializes a list of methods and C functions that return a localized string
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NonLocalizedStringChecker::initLocStringsMethods">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 564,
   FQN="(anonymous namespace)::NonLocalizedStringChecker::initLocStringsMethods", NM="_ZNK12_GLOBAL__N_125NonLocalizedStringChecker21initLocStringsMethodsERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZNK12_GLOBAL__N_125NonLocalizedStringChecker21initLocStringsMethodsERN5clang10ASTContextE")
  //</editor-fold>
  private void initLocStringsMethods(final ASTContext /*&*/ Ctx) /*const*/ {
    if (!LSM.empty()) {
      return;
    }
    
    IdentifierInfo /*P*/ LocalizedStringMacro[/*3*/] = new IdentifierInfo /*P*/  [/*3*/] {
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"localizedStringForKey"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"value"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"table")))};
    LSM.insert(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , Selector>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSBundle"))), Ctx.Selectors.getSelector(3, create_type$ptr(LocalizedStringMacro)))/* }*/);
    LSM.insert(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , Selector>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSDateFormatter"))), Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"stringFromDate")))))/* }*/);
    IdentifierInfo /*P*/ LocalizedStringFromDate[/*3*/] = new IdentifierInfo /*P*/  [/*3*/] {
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"localizedStringFromDate"))), $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"dateStyle"))), 
      $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"timeStyle")))};
    LSM.insert(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , Selector>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSDateFormatter"))), Ctx.Selectors.getSelector(3, create_type$ptr(LocalizedStringFromDate)))/* }*/);
    LSM.insert(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , Selector>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"NSNumberFormatter"))), Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"stringFromNumber")))))/* }*/);
    LSM.insert(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , Selector>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"UITextField"))), Ctx.Selectors.getNullarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"text")))))/* }*/);
    LSM.insert(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , Selector>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"UITextView"))), Ctx.Selectors.getNullarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"text")))))/* }*/);
    LSM.insert(/*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , Selector>(JD$T$RR_T1$RR.INSTANCE, $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"UILabel"))), Ctx.Selectors.getNullarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"text")))))/* }*/);
    LSF.insert($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"CFDateFormatterCreateStringWithDate"))));
    ;
    LSF.insert($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"CFDateFormatterCreateStringWithAbsoluteTime"))));
    ;
    LSF.insert($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"CFNumberFormatterCreateStringWithNumber"))));
    ;
  }

  
  
  /// Returns true if the given SVal is marked as NonLocalized in the program
  /// state
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NonLocalizedStringChecker::hasNonLocalizedState">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 613,
   FQN="(anonymous namespace)::NonLocalizedStringChecker::hasNonLocalizedState", NM="_ZNK12_GLOBAL__N_125NonLocalizedStringChecker20hasNonLocalizedStateEN5clang4ento4SValERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZNK12_GLOBAL__N_125NonLocalizedStringChecker20hasNonLocalizedStateEN5clang4ento4SValERNS2_14CheckerContextE")
  //</editor-fold>
  private boolean hasNonLocalizedState(SVal S, 
                      final CheckerContext /*&*/ C) /*const*/ {
    /*const*/ MemRegion /*P*/ mt = S.getAsRegion();
    if ((mt != null)) {
      /*const*/ LocalizedState /*P*/ LS = C.getState().$arrow().get(ProgramStateTraitLocalizedMemMap.$Instance, mt);
      if ((LS != null) && LS.isNonLocalized()) {
        return true;
      }
    }
    return false;
  }

  
  /// Returns true if the given SVal is marked as Localized in the program state
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NonLocalizedStringChecker::hasLocalizedState">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 600,
   FQN="(anonymous namespace)::NonLocalizedStringChecker::hasLocalizedState", NM="_ZNK12_GLOBAL__N_125NonLocalizedStringChecker17hasLocalizedStateEN5clang4ento4SValERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZNK12_GLOBAL__N_125NonLocalizedStringChecker17hasLocalizedStateEN5clang4ento4SValERNS2_14CheckerContextE")
  //</editor-fold>
  private boolean hasLocalizedState(SVal S, 
                   final CheckerContext /*&*/ C) /*const*/ {
    /*const*/ MemRegion /*P*/ mt = S.getAsRegion();
    if ((mt != null)) {
      /*const*/ LocalizedState /*P*/ LS = C.getState().$arrow().get(ProgramStateTraitLocalizedMemMap.$Instance, mt);
      if ((LS != null) && LS.isLocalized()) {
        return true;
      }
    }
    return false;
  }

  
  /// Marks the given SVal as NonLocalized in the program state
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NonLocalizedStringChecker::setNonLocalizedState">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 636,
   FQN="(anonymous namespace)::NonLocalizedStringChecker::setNonLocalizedState", NM="_ZNK12_GLOBAL__N_125NonLocalizedStringChecker20setNonLocalizedStateEN5clang4ento4SValERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZNK12_GLOBAL__N_125NonLocalizedStringChecker20setNonLocalizedStateEN5clang4ento4SValERNS2_14CheckerContextE")
  //</editor-fold>
  private void setNonLocalizedState(/*const*/ SVal S, 
                      final CheckerContext /*&*/ C) /*const*/ {
    /*const*/ MemRegion /*P*/ mt = S.getAsRegion();
    if ((mt != null)) {
      IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        State = C.getState().$arrow().set(ProgramStateTraitLocalizedMemMap.$Instance, mt, LocalizedState.getNonLocalized());
        $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
      } finally {
        if (State != null) { State.$destroy(); }
        $c$.$destroy();
      }
    }
  }

  
  /// Marks the given SVal as Localized in the program state
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NonLocalizedStringChecker::setLocalizedState">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 625,
   FQN="(anonymous namespace)::NonLocalizedStringChecker::setLocalizedState", NM="_ZNK12_GLOBAL__N_125NonLocalizedStringChecker17setLocalizedStateEN5clang4ento4SValERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZNK12_GLOBAL__N_125NonLocalizedStringChecker17setLocalizedStateEN5clang4ento4SValERNS2_14CheckerContextE")
  //</editor-fold>
  private void setLocalizedState(/*const*/ SVal S, 
                   final CheckerContext /*&*/ C) /*const*/ {
    /*const*/ MemRegion /*P*/ mt = S.getAsRegion();
    if ((mt != null)) {
      IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        State = C.getState().$arrow().set(ProgramStateTraitLocalizedMemMap.$Instance, mt, LocalizedState.getLocalized());
        $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
      } finally {
        if (State != null) { State.$destroy(); }
        $c$.$destroy();
      }
    }
  }

  
  
  /// Checks to see if the method / function declaration includes
  /// __attribute__((annotate("returns_localized_nsstring")))
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NonLocalizedStringChecker::isAnnotatedAsLocalized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 589,
   FQN="(anonymous namespace)::NonLocalizedStringChecker::isAnnotatedAsLocalized", NM="_ZNK12_GLOBAL__N_125NonLocalizedStringChecker22isAnnotatedAsLocalizedEPKN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZNK12_GLOBAL__N_125NonLocalizedStringChecker22isAnnotatedAsLocalizedEPKN5clang4DeclE")
  //</editor-fold>
  private boolean isAnnotatedAsLocalized(/*const*/ Decl /*P*/ D) /*const*/ {
    if (!(D != null)) {
      return false;
    }
    return std.any_of(D.specific_attr_begin(AnnotateAttr.class), 
        D.specific_attr_end(AnnotateAttr.class), /*[]*/ (/*const*/ AnnotateAttr /*P*/ Ann) -> {
              return $eq_StringRef(Ann.getAnnotation(), /*STRINGREF_STR*/"returns_localized_nsstring");
            });
  }

  
  /// Reports a localization error for the passed in method call and SVal
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NonLocalizedStringChecker::reportLocalizationError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 677,
   FQN="(anonymous namespace)::NonLocalizedStringChecker::reportLocalizationError", NM="_ZNK12_GLOBAL__N_125NonLocalizedStringChecker23reportLocalizationErrorEN5clang4ento4SValERKNS2_14ObjCMethodCallERNS2_14CheckerContextEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZNK12_GLOBAL__N_125NonLocalizedStringChecker23reportLocalizationErrorEN5clang4ento4SValERKNS2_14ObjCMethodCallERNS2_14CheckerContextEi")
  //</editor-fold>
  private void reportLocalizationError(SVal S, final /*const*/ ObjCMethodCall /*&*/ M, final CheckerContext /*&*/ C) /*const*/ {
    reportLocalizationError(S, M, C, 
                         0);
  }
  private void reportLocalizationError(SVal S, final /*const*/ ObjCMethodCall /*&*/ M, final CheckerContext /*&*/ C, 
                         int argumentNumber/*= 0*/) /*const*/ {
    std.unique_ptr<BugReport> R = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      // Don't warn about localization errors in classes and methods that
      // may be debug code.
      if (LocalizationCheckerStatics.isDebuggingContext(C)) {
        return;
      }
      
      ExplodedNode /*P*/ ErrNode = C.getPredecessor();
      final/*static*/ CheckerProgramPointTag Tag = reportLocalizationError$$.Tag;
      $c$.clean(ErrNode = C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState())), C.getPredecessor(), $AddrOf(Tag)));
      if (!(ErrNode != null)) {
        return;
      }
      
      // Generate the bug report.
      R/*J*/= new std.unique_ptr<BugReport>(new BugReport(BT.$star(), new StringRef(/*KEEP_STR*/"User-facing text should use localized string macro"), ErrNode));
      if ((argumentNumber != 0)) {
        R.$arrow().addRange(M.getArgExpr(argumentNumber - 1).getSourceRange());
      } else {
        R.$arrow().addRange(M.getSourceRange());
      }
      R.$arrow().markInteresting(new SVal(S));
      
      /*const*/ MemRegion /*P*/ StringRegion = S.getAsRegion();
      if ((StringRegion != null)) {
        R.$arrow().addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new NonLocalizedStringBRVisitor(StringRegion)))))); $c$.clean();
      }
      
      C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
    } finally {
      if (R != null) { R.$destroy(); }
      $c$.$destroy();
    }
  }
  private static final class reportLocalizationError$$ {
    static final/*static*/ CheckerProgramPointTag Tag/*J*/= new CheckerProgramPointTag(new StringRef(/*KEEP_STR*/"NonLocalizedStringChecker"), 
        new StringRef(/*KEEP_STR*/"UnlocalizedString"));
  }

  
  
  /// Returns the argument number requiring localized string if it exists
  /// otherwise, returns -1
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NonLocalizedStringChecker::getLocalizedArgumentForSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 713,
   FQN="(anonymous namespace)::NonLocalizedStringChecker::getLocalizedArgumentForSelector", NM="_ZNK12_GLOBAL__N_125NonLocalizedStringChecker31getLocalizedArgumentForSelectorEPKN5clang14IdentifierInfoENS1_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZNK12_GLOBAL__N_125NonLocalizedStringChecker31getLocalizedArgumentForSelectorEPKN5clang14IdentifierInfoENS1_8SelectorE")
  //</editor-fold>
  private int getLocalizedArgumentForSelector(/*const*/ IdentifierInfo /*P*/ Receiver, Selector S) /*const*/ {
    DenseMapIterator</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>> method = UIMethods.find(Receiver);
    if (method.$eq(/*NO_ITER_COPY*/UIMethods.end())) {
      return -1;
    }
    
    DenseMapIteratorTypeUChar<Selector> argumentIterator = method.$arrow().getSecond().find(S);
    if (argumentIterator.$eq(/*NO_ITER_COPY*/method.$arrow().getSecond().end())) {
      return -1;
    }
    
    int argumentNumber = $uchar2int(argumentIterator.$arrow().getSecond());
    return argumentNumber;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NonLocalizedStringChecker::NonLocalizedStringChecker">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 109,
   FQN="(anonymous namespace)::NonLocalizedStringChecker::NonLocalizedStringChecker", NM="_ZN12_GLOBAL__N_125NonLocalizedStringCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN12_GLOBAL__N_125NonLocalizedStringCheckerC1Ev")
  //</editor-fold>
  public NonLocalizedStringChecker() {
    // : Checker<PostCall, PreObjCMessage, PostObjCMessage, PostStmt<ObjCStringLiteral> >(), BT(), UIMethods(), LSM(), LSF(), IsAggressive() 
    //START JInit
    super();
    this.BT = new std.unique_ptr<BugType>();
    this.UIMethods = new DenseMap</*const*/ IdentifierInfo /*P*/ , DenseMapTypeUChar<Selector>>(IdentifierInfo.DMI$IdentifierInfoPtr, new DenseMapTypeUChar<Selector>(DenseMapInfoSelector.$Info(), (byte) 0));
    this.LSM = new SmallSet<std.pairPtrType</*const*/ IdentifierInfo /*P*/ , Selector>>(12, 
                                                    new std.pairPtrType((/*const*/ IdentifierInfo /*P*/)null, Selector.DEFAULT),
                                                    PAIR_IIPTR_SELECTOR_COMPARATOR);
    this.LSF = new SmallSetT$PLess$T$P</*const*/ IdentifierInfo /*P*/ >(5);
    this.IsAggressive = new DefaultBool();
    //END JInit
    BT.reset(new BugType(this, new StringRef(/*KEEP_STR*/"Unlocalizable string"), 
            new StringRef(/*KEEP_STR*/"Localizability Issue (Apple)")));
  }

  
  // When this parameter is set to true, the checker assumes all
  // methods that return NSStrings are unlocalized. Thus, more false
  // positives will be reported.
  public DefaultBool IsAggressive;
  
  
  /// Check if the string being passed in has NonLocalized state
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NonLocalizedStringChecker::checkPreObjCMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 730,
   FQN="(anonymous namespace)::NonLocalizedStringChecker::checkPreObjCMessage", NM="_ZNK12_GLOBAL__N_125NonLocalizedStringChecker19checkPreObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZNK12_GLOBAL__N_125NonLocalizedStringChecker19checkPreObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPreObjCMessage(final /*const*/ ObjCMethodCall /*&*/ msg, 
                     final CheckerContext /*&*/ C) /*const*/ {
    initUIMethods(C.getASTContext());
    
    /*const*/ ObjCInterfaceDecl /*P*/ OD = msg.getReceiverInterface();
    if (!(OD != null)) {
      return;
    }
    /*const*/ IdentifierInfo /*P*/ odInfo = OD.getIdentifier();
    
    Selector S = msg.getSelector();
    
    std.string SelectorString = S.getAsString();
    StringRef SelectorName = new StringRef(SelectorString);
    assert (!SelectorName.empty());
    if (odInfo.isStr(/*KEEP_STR*/"NSString")) {
      // Handle the case where the receiver is an NSString
      // These special NSString methods draw to the screen
      if (!(SelectorName.startswith(/*STRINGREF_STR*/"drawAtPoint")
         || SelectorName.startswith(/*STRINGREF_STR*/"drawInRect")
         || SelectorName.startswith(/*STRINGREF_STR*/"drawWithRect"))) {
        return;
      }
      
      SVal svTitle = msg.getReceiverSVal();
      
      boolean isNonLocalized = hasNonLocalizedState(new SVal(svTitle), C);
      if (isNonLocalized) {
        reportLocalizationError(new SVal(svTitle), msg, C);
      }
    }
    
    int argumentNumber = getLocalizedArgumentForSelector(odInfo, new Selector(S));
    // Go up each hierarchy of superclasses and their protocols
    while (argumentNumber < 0 && OD.getSuperClass() != null) {
      for (/*const*/ ObjCProtocolDecl /*P*/ P : OD.all_referenced_protocols()) {
        argumentNumber = getLocalizedArgumentForSelector(P.getIdentifier(), new Selector(S));
        if (argumentNumber >= 0) {
          break;
        }
      }
      if (argumentNumber < 0) {
        OD = OD.getSuperClass();
        argumentNumber = getLocalizedArgumentForSelector(OD.getIdentifier(), new Selector(S));
      }
    }
    if (argumentNumber < 0) { // There was no match in UIMethods
      return;
    }
    
    SVal svTitle = msg.getArgSVal(argumentNumber);
    {
      
      /*const*/ ObjCStringRegion /*P*/ SR = dyn_cast_or_null_ObjCStringRegion(svTitle.getAsRegion());
      if ((SR != null)) {
        StringRef stringValue = SR.getObjCStringLiteral().getString$Const().getString();
        if ((stringValue.trim().size() == 0 && $greater_uint(stringValue.size(), 0))
           || stringValue.empty()) {
          return;
        }
        if (!IsAggressive.$ConstBoolRef() && unicode.columnWidthUTF8(new StringRef(stringValue)) < 2) {
          return;
        }
      }
    }
    
    boolean isNonLocalized = hasNonLocalizedState(new SVal(svTitle), C);
    if (isNonLocalized) {
      reportLocalizationError(new SVal(svTitle), msg, C, argumentNumber + 1);
    }
  }

  
  /// Marks a string being returned by an ObjC method as localized
  /// if it is in LocStringMethods or the method is annotated
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NonLocalizedStringChecker::checkPostObjCMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 868,
   FQN="(anonymous namespace)::NonLocalizedStringChecker::checkPostObjCMessage", NM="_ZNK12_GLOBAL__N_125NonLocalizedStringChecker20checkPostObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZNK12_GLOBAL__N_125NonLocalizedStringChecker20checkPostObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPostObjCMessage(final /*const*/ ObjCMethodCall /*&*/ msg, 
                      final CheckerContext /*&*/ C) /*const*/ {
    initLocStringsMethods(C.getASTContext());
    if (!msg.isInstanceMessage()) {
      return;
    }
    
    /*const*/ ObjCInterfaceDecl /*P*/ OD = msg.getReceiverInterface();
    if (!(OD != null)) {
      return;
    }
    /*const*/ IdentifierInfo /*P*/ odInfo = OD.getIdentifier();
    
    Selector S = msg.getSelector();
    std.string SelectorName = S.getAsString();
    
    std.pairPtrType</*const*/ IdentifierInfo /*P*/ , Selector> MethodDescription = /*{ */new std.pairPtrType</*const*/ IdentifierInfo /*P*/ , Selector>(JD$T$RR_T1$RR.INSTANCE, odInfo, new Selector(/*Fwd*/S))/* }*/;
    if ((LSM.count(MethodDescription) != 0) || isAnnotatedAsLocalized(msg.getDecl())) {
      SVal sv = msg.getReturnValue();
      setLocalizedState(new SVal(sv), C);
    }
  }

  
  /// Marks all empty string literals as localized
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NonLocalizedStringChecker::checkPostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 892,
   FQN="(anonymous namespace)::NonLocalizedStringChecker::checkPostStmt", NM="_ZNK12_GLOBAL__N_125NonLocalizedStringChecker13checkPostStmtEPKN5clang17ObjCStringLiteralERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZNK12_GLOBAL__N_125NonLocalizedStringChecker13checkPostStmtEPKN5clang17ObjCStringLiteralERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ ObjCStringLiteral /*P*/ SL, 
               final CheckerContext /*&*/ C) /*const*/ {
    SVal sv = C.getSVal(SL);
    setNonLocalizedState(new SVal(sv), C);
  }

  
  /// Marks a string being returned by any call as localized
  /// if it is in LocStringFunctions (LSF) or the function is annotated.
  /// Otherwise, we mark it as NonLocalized (Aggressive) or
  /// NonLocalized only if it is not backed by a SymRegion (Non-Aggressive),
  /// basically leaving only string literals as NonLocalized.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NonLocalizedStringChecker::checkPostCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 822,
   FQN="(anonymous namespace)::NonLocalizedStringChecker::checkPostCall", NM="_ZNK12_GLOBAL__N_125NonLocalizedStringChecker13checkPostCallERKN5clang4ento9CallEventERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZNK12_GLOBAL__N_125NonLocalizedStringChecker13checkPostCallERKN5clang4ento9CallEventERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPostCall(final /*const*/ CallEvent /*&*/ Call, 
               final CheckerContext /*&*/ C) /*const*/ {
    initLocStringsMethods(C.getASTContext());
    if (!(Call.getOriginExpr() != null)) {
      return;
    }
    
    // Anything that takes in a localized NSString as an argument
    // and returns an NSString will be assumed to be returning a
    // localized NSString. (Counter: Incorrectly combining two LocalizedStrings)
    /*const*/ QualType RT = Call.getResultType();
    if (LocalizationCheckerStatics.isNSStringType(new QualType(RT), C.getASTContext())) {
      for (/*uint*/int i = 0; $less_uint(i, Call.getNumArgs()); ++i) {
        SVal argValue = Call.getArgSVal(i);
        if (hasLocalizedState(new SVal(argValue), C)) {
          SVal sv = Call.getReturnValue();
          setLocalizedState(new SVal(sv), C);
          return;
        }
      }
    }
    
    /*const*/ Decl /*P*/ D = Call.getDecl();
    if (!(D != null)) {
      return;
    }
    
    /*const*/ IdentifierInfo /*P*/ Identifier = Call.getCalleeIdentifier();
    
    SVal sv = Call.getReturnValue();
    if (isAnnotatedAsLocalized(D) || LSF.count(Identifier) != 0) {
      setLocalizedState(new SVal(sv), C);
    } else if (LocalizationCheckerStatics.isNSStringType(new QualType(RT), C.getASTContext())
       && !hasLocalizedState(new SVal(sv), C)) {
      if (IsAggressive.$ConstBoolRef()) {
        setNonLocalizedState(new SVal(sv), C);
      } else {
        /*const*/ SymbolicRegion /*P*/ SymReg = dyn_cast_or_null_SymbolicRegion(sv.getAsRegion());
        if (!(SymReg != null)) {
          setNonLocalizedState(new SVal(sv), C);
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NonLocalizedStringChecker::~NonLocalizedStringChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 60,
   FQN="(anonymous namespace)::NonLocalizedStringChecker::~NonLocalizedStringChecker", NM="_ZN12_GLOBAL__N_125NonLocalizedStringCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN12_GLOBAL__N_125NonLocalizedStringCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    LSF.$destroy();
    LSM.$destroy();
    UIMethods.$destroy();
    BT.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public void $checkPostStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof ObjCStringLiteral) {
      checkPostStmt((ObjCStringLiteral) stmt, C);
    }
  }

  private final CheckBase $CHECKS[] = {
    new PostCall(),
    new PreObjCMessage(),
    new PostObjCMessage(),
    new org.clang.staticanalyzer.core.ento.check.PostStmt<ObjCStringLiteral>(ObjCStringLiteral.class)
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }
  
  public static final Comparator<std.pairPtrType</*const*/ IdentifierInfo /*P*/ , Selector>> PAIR_IIPTR_SELECTOR_COMPARATOR = new Comparator<std.pairPtrType</*const*/ IdentifierInfo /*P*/ , Selector>>() {
    @Override
    public int compare(std.pairPtrType</*const*/ IdentifierInfo /*P*/ , Selector> o1, std.pairPtrType</*const*/ IdentifierInfo /*P*/ , Selector> o2) {
      assert o1.first != null;
      assert o2.first != null;
      int res = (o1.first.compareKey(o2.first));
      if (res != 0) {
        return res;
      }
      assert o1.first == o2.first : "equal IdentifierInfo must be equal instances " + NativeTrace.getIdentityStr(o1.first) + " vs. " + NativeTrace.getIdentityStr(o2.first);
      return Selector.COMPARATOR.compare(o1.second, o2.second);
    }
  };
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BT=" + BT // NOI18N
              + ", UIMethods=" + UIMethods // NOI18N
              + ", LSM=" + LSM // NOI18N
              + ", LSF=" + LSF // NOI18N
              + ", IsAggressive=" + IsAggressive // NOI18N
              + super.toString(); // NOI18N
  }
}
